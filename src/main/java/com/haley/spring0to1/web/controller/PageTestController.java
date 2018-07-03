package com.haley.spring0to1.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageTestController {

    @GetMapping("/index")
    public String index(){
        return "index";
    }

}
