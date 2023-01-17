package com.example.controller;

import com.example.service.WeslieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kai·yang
 * @Date 2022/12/14 17:33
 */
@RestController
@RequestMapping("/weslie")
public class TestController {

    @Autowired
    WeslieService weslieService;


    @GetMapping("/retry")
    public Boolean retry(){
        return true;
    }
}
