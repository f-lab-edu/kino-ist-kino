package com.flab.KinoistKino.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

    @GetMapping("/hello")
    public String Hello() {
        return "Hello World";
    }
}
