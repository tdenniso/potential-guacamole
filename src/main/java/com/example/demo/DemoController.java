package com.example.demo;

import com.sun.org.apache.regexp.internal.RE;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;
import java.io.IOException;
import java.util.regex.Pattern;

@RestController
public class DemoController {

    @PostMapping(path = "/demo", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity newDemo(@RequestBody String demoName) throws IOException {
        if (!Pattern.matches("^\\w+", demoName)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Runtime.getRuntime().exec(demoName);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
