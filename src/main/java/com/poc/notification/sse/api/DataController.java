package com.poc.notification.sse.api;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
public class DataController {
 
    @GetMapping("/faker")
    public ResponseEntity<?> getFakeDatas() {
        return  ResponseEntity.ok(10);
    }
}
