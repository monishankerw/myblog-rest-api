package com.myblogrestapi.security;

import org.springframework.http.HttpStatus;

public class BlogAPIException extends Throwable {
    public BlogAPIException(HttpStatus badRequest, String invalid_jwt_signature) {
    }
}
