package com.example.aop.controller;

import com.example.aop.dto.TestDomain;
import com.example.aop.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private TestService testService;

    @GetMapping("test")
    public String test(@RequestParam("p1") String p1) {
        TestDomain testDomain = new TestDomain();
        testDomain.setId("1");
        testDomain.setTitle("t1");
        testService.log1(p1, testDomain);
        testService.log2(p1, testDomain);
        testService.throwException();
        return "hello aop";
    }
}
