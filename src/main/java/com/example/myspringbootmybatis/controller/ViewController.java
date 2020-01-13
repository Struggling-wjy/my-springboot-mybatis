package com.example.myspringbootmybatis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {
    @RequestMapping("/insert")
    public String insertUser(){
        return "insert";
    }
}
