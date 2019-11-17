package com.pedrotavares.springbootordermanagement.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class Index {

    @GetMapping()
    Map<String, String> index(){
        Map<String, String> map = new HashMap<String, String>();
        map.put("title", "Home Page Order Management System.");
        map.put("date", new Date().toString());
        return  map;
    }
}
