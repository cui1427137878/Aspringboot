package com.tedu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileController {
    @RequestMapping("/test.do")
 public String test(){
        return  "test";
    }
}
