package com.agoda.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/upload")
public class UploadPhot {

    @RequestMapping("/photo")
    public String addPhoto(){
        return "uploaded";
    }
}
