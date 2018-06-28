package com.haley.spring0to1.web.controller;

import com.haley.spring0to1.dao.DemoRepository;
import com.haley.spring0to1.domain.model.Demo;
import com.haley.spring0to1.domain.model.User;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api")
public class TestController {

    @Autowired
    private Runnable runnable;

    @Autowired
    private DemoRepository demoRepository;

    //带参数和属性的Get请求
    @RequestMapping(value = "/testget/{name}/{age}", method = RequestMethod.GET, produces = "text/html;charset=UTF-8", params = "myParam=myValue")
    @ResponseBody
    public String testGet(@PathVariable(value = "name") String name1, @PathVariable(value = "age") int age1, @RequestParam String testP) {
        return "hello Get，你好啊:" + name1 + " age:" + age1 + " testP:" + testP;
    }

    //
    @RequestMapping(value = "/testget2/{leftId}", method = RequestMethod.GET)
    @ResponseBody
    public String testGet2(@PathVariable String leftId, @MatrixVariable(name = "q", pathVar = "leftId") String int1) {
        return "hello Get，你好啊 int1:" + int1 + " leftId:" + leftId;
    }

    @RequestMapping(path = "/pets/{petId}", method = RequestMethod.GET)
    public void findPet(@PathVariable String petId, @MatrixVariable int q) {
        System.out.print("findPet:" + petId);
        System.out.print("q:" + q);
    }

    //带body的post请求
    @RequestMapping(value = "/testpost", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String testPost(@RequestBody String test) {
        System.out.print("test:" + test);
        return "hello Post，你好啊:" + test;
    }

    //带json数据的post请求
    @RequestMapping(value = "/testjsonpost", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String testJsonPost(@RequestBody String test) {

        runnable.run();

        //解析传入的json
        JSONObject jsonObject = JSONObject.fromObject(test);
        String value = jsonObject.getString("key");

        //封装一下再返回
        JSONObject result = new JSONObject();
        result.put("name", "huanglei");
        result.put("age", 27);
        result.put("accessToken", "tests");
        result.put("value", value);
        return result.toString();
    }

    @RequestMapping(value = {"/hellp", "/hi"})
    public String hello(Map<String, Object> map) {
        map.put("msg", "Hello Thymeleaf");
        System.out.println("hello:" + map.size());
        return "hello";
    }

    @RequestMapping(value = "/user")
    @ResponseBody
    public User user() {
        User user = new User();

        user.setId(1);
        user.setUsername("haley");
        user.setPassword("dad11112");
        user.setBirthday(new Date());
        return user;
    }

    @PostMapping(value = "/addDemo")
    public Demo addDemo(@RequestParam("demoName") String demoName,
                        @RequestParam("demoSize") Integer demoSize) {
        Demo demo = new Demo();
        demo.setDemoName(demoName);
        demo.setDemoSize(demoSize);
        System.out.println("Demo:" + demo.toString());
        return demoRepository.save(demo);
    }

    @DeleteMapping(value = "/deleteDemo/{id}")
    public void delDemo(@PathVariable("id") Integer id) {
        demoRepository.delete(id);
    }

    @PutMapping(value = "/updateDemo/{id}")
    public Demo updateDemo(@PathVariable("id") Integer id,
                           @RequestParam("demoName") String demoName,
                           @RequestParam("demoSize") Integer demoSize){
        Demo demo = new Demo();
        demo.setId(id);
        demo.setDemoName(demoName);
        demo.setDemoSize(demoSize);
       return demoRepository.save(demo);
    }

    @GetMapping("/getDemos")
    public List<Demo> findAllDemo(){
        return demoRepository.findAll();
    }

    @GetMapping("/getOneDemo/{id}")
    public Demo findOneDemo(@PathVariable("id") Integer id){
        return demoRepository.findOne(id);
    }

}
