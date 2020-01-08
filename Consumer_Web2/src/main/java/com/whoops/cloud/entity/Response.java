package com.whoops.cloud.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response {

    private boolean success;

    private String message;

    private Object body;

    public Response() {
    }

    public Response(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public Response(boolean success, String message, Object body) {
        this.success = success;
        this.message = message;
        this.body = body;
    }
}
