package com.bruce.demo.my.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bruce
 * @date 2023/6/5
 * @desc test
 */
@RestController
@RequestMapping("test")
@Slf4j
public class TestController {

    @GetMapping("a")
    public String a(@RequestParam String name) {
        log.info("name=={}",name);
        return "this is a!";
    }
}
