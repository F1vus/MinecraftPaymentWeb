package net.fiv.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class FrontendController {

    @GetMapping
    @ResponseBody
    public String hello() {
        return "<h1>Hello World</h1>";
    }

}
