package com.queryparser.Model;

import org.springframework.http.HttpStatus;

import java.util.List;

public class Response {
    private String response;
    private HttpStatus status;


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
