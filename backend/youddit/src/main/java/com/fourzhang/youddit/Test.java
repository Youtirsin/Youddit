package com.fourzhang.youddit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {

    @GetMapping("/test/1")
    public String test1() {
        return "Youtirsin: XD";
    }


    @GetMapping("/test/2")
    public String test2() {
        return "Youtirsin: XD";
    }
}
