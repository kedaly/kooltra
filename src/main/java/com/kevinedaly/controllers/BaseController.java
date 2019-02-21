package com.kevinedaly.controllers;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/hello")
public class BaseController {

    @Get
    public String hello() {
        return "Hello";
    }
}
