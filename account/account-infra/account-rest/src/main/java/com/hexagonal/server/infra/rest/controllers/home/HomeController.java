package com.hexagonal.server.infra.rest.controllers.home;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/")
public class HomeController {

    @GetMapping()
    public String home() {
        return "<h1>Hexagonal Architecture Server</h1>";
    }

}
