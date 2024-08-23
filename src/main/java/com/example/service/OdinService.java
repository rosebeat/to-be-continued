package com.example.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author kai·yang
 * @Date 2023/1/7 11:06
 */


@Service
@Slf4j
public class OdinService {


    @Autowired
    OdinRetryService weslieRetryService;



    public boolean validateRetry(){


        return true;
    }






}
