package com.hexagonal.architecture.server.infra.rest.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping(path = "/")
    public String home() {
        return "<h1>Hexagonal Architecture Server</h1>";
    }

}
