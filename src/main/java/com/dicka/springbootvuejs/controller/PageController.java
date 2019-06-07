package com.dicka.springbootvuejs.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class PageController {

    @GetMapping(value = {"/", "/index", "/home"})
    public String getProduct(){
        log.debug("--HOME--");
        return "products";
    }
}
