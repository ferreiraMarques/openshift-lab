package com.openshift.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/demo")
public class DemoController {
    
    @Value("${SUM}")
    private int sum;

    @GetMapping
    public ResponseEntity<Integer> checkStatus() {
        return new ResponseEntity(5 + this.sum, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Boolean> testCreate() {
        return new ResponseEntity(true, HttpStatus.CREATED);
    }
}
