package com.cos.security1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // view를 리턴한다.
public class IndexController {
    
    @GetMapping({"", "/"})
    public String index() {
        // 스프링이 mustache를 권장
        // mustache 기본폴더 src/main/resources/
        // view resolver : (prefix) /templates/ (suffix) .mustache >> 생략가능
        return "index"; // src/main/resources/templates/index.mustache
    }
}
