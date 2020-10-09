package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class DemoController {

    @PostMapping(path = "/demo", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void newDemo(@RequestBody String demoName) throws IOException {
        Runtime.getRuntime().exec(demoName);
    }
}
