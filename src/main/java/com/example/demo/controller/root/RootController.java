package com.example.demo.controller.root;

import com.example.demo.service.root.RootService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RootController {

    private final RootService rootService;

    public RootController(RootService rootService) {
        this.rootService = rootService;
    }

    @GetMapping("/")
    public List<String> root() {
        return rootService.showAllRoutes();
    }

}
