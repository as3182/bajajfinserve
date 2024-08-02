package com.bajaj.bajajfinserv.controller;

import com.bajaj.bajajfinserv.services.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class Assignment {

    @Autowired
    private DataService dataService;

    @GetMapping("/bfhl")
    public ResponseEntity<Map<String, Integer>> getDetails() {
        Map<String, Integer> response = new HashMap<>();
        response.put("operation_code", 1);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/bfhl")
    public ResponseEntity<Map<String, Object>> processData(@RequestBody Map<String, List<String>> request) {
        List<String> data = request.get("data");
        Map<String, Object> response = dataService.processData(data);

        if (response.isEmpty()) {
            return new ResponseEntity<>(Collections.emptyMap(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

}
