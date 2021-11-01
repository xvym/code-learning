package cn.com.xvym.action.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Xv
 * @Date: 2021/8/22 11:24
 * @Description:
 */
@RestController
@RequestMapping("/api/")
public class HelloWorldController {

    @GetMapping("/hello-world")
    public String helloWorld() {
        return "hello world!";
    }
}
