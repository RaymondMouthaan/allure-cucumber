package org.mouthaan.demo.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "file_name",
        "content_base64"
})
public class Result {

    @JsonProperty("file_name")
    public String fileName;
    @JsonProperty("content_base64")
    public String contentBase64;

    public Result(String fileName, String contentBase64) {
        this.fileName = fileName;
        this.contentBase64 = contentBase64;
    }
}
