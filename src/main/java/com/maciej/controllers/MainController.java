package com.maciej.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    @RequestMapping(value = "/")
    @ResponseBody
    public List<String> hello(){
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        return list;
    }
}
