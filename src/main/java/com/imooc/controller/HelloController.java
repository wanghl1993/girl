package com.imooc.controller;

import com.imooc.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by xeshen_channelsoft on 2018/6/21.
 */
//@Controller
//@ResponseBody
@RestController
@RequestMapping("/hello")
public class HelloController {

//    @Value("${cupSize}")
//    private String cupSize;
//
//    @Value("${age}")
//    private Integer age;
//
//    @Value("${content}")
//    private String content;
//    @RequestMapping(value="/hello2",method = RequestMethod.GET)
//    pulbic String what(){
//        return cupSize;
//    }

    @Autowired
    private GirlProperties girlProperties;

//    @RequestMapping(value={"/hello","/hi"},method = RequestMethod.GET)
//    @RequestMapping(value= "/say")
    @GetMapping(value = "/say")
    public String say(@RequestParam(value = "id",required = false ,defaultValue = "0") Integer myId){
        return "id:" + myId;
//        return "Hello Spring Boot!";
//        return cupSize + age;
//        return content;
//        return girlProperties.getCupSize();
//        return "index";
    }
}



