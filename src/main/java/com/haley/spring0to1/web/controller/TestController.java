package com.haley.spring0to1.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/api")
public class TestController {

    @RequestMapping(value = "/testget/{name}",method = RequestMethod.GET,produces = "text/html;charset=UTF-8",params = "myParam=myValue")
    @ResponseBody
    public String testGet(@PathVariable String name){
        return "hello Get，你好啊:"+name;
    }

    @RequestMapping(value = "/testpost",method = RequestMethod.POST,produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String testPost(@RequestBody String test){
        System.out.print("test:"+test);
        return "hello Post，你好啊:"+test;
    }
}
