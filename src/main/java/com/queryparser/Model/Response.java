package com.queryparser.Model;

import org.springframework.http.HttpStatus;

public class Response {
    private HttpStatus status;
    private String response;

    public Response(String response, HttpStatus status) {
        this.response = response;
        this.status = status;
    }

    public String getResponse() {
        return response;
    }

    public HttpStatus getStatus() {
        return status;
    }

}
