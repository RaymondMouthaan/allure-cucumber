package org.mouthaan.demo.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.stream.Stream;

import static io.restassured.RestAssured.given;

public class Docker {

    // Enable @Test after mvn clean verify to publish results to Allure Docker
//    @Test
    public void publishToAllureDockerApi() {
        final URI uri = URI.create("http://allure-api.indonesia/send-results");
        final String allureResults = "target/results/allure-results";

        ResultsJson resultsJson = new ResultsJson();

        try (Stream<Path> stream = Files.list(Paths.get(allureResults)).filter(Files::isRegularFile)) {
            stream.forEach(p -> {
                try {
                    resultsJson.results.add(
                            new Result(p.getFileName().toString(), encodeFileBase64(p.toFile()))
                    );
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            final String content = objectMapper.writeValueAsString(resultsJson);
            RequestSpecification requestSpecification = given().header("Content-Type", "application/json").body(content);
            Response response = requestSpecification.when().post(uri);
            response.prettyPrint();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    private static String encodeFileBase64(File file) throws IOException {
        return new String(
                Base64.getEncoder().encode(
                        FileUtils.readFileToByteArray(file)
                )
        );
    }
}
