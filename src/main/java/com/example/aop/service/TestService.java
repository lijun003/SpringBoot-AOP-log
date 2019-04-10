package com.example.aop.service;

import com.example.aop.dto.TestDomain;
import com.example.aop.annotation.SysLog;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    @SysLog("log-1")
    public void log1(String name, TestDomain testDomain) {
        System.out.println("print log 1" + name + " " + testDomain.toString());
    }

    @SysLog("log-2")
    public void log2(String name, TestDomain testDomain) {
        System.out.println("print log 2" + name + " " + testDomain.toString());
    }


    @SysLog("throw-exception")
    public void throwException() {
        System.out.println("throw exception");
        int i = 3/0;
    }
}
