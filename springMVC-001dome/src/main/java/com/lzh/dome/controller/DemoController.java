package com.lzh.dome.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DemoController {


    @RequestMapping(value = "/demo")
    public String testDemo(){
        System.out.println("服务器访问成功！");
        return "demo";
    }


    @RequestMapping(value = "/req",method = RequestMethod.POST)
    public String testReq(String name,String age){
        System.out.println(name);
        System.out.println(age);
        return "req";
    }

    @RequestMapping("/dong/{name}/{uage}")
    public String testDong(@PathVariable String name, @PathVariable("uage") String uage){
        System.out.println(name);
        System.out.println(uage);
        return "req";
    }

    @RequestMapping(value = "/reqparam")
    public String testReqParam(@RequestParam("name") String uname, @RequestParam("age") String uage){
        System.out.println(uname);
        System.out.println(uage);
        return "req";
    }



}
