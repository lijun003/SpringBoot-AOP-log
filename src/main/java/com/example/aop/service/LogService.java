package com.example.aop.service;

import org.springframework.stereotype.Service;

@Service
public class LogService {

    public void log(long time, String location) {
        System.out.println(location + " at: " + time);
    }
}
