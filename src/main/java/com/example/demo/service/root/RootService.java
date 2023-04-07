package com.example.demo.service.root;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RootService implements IRootService {


    @Override
    public List<String> showAllRoutes() {
        List<String> routes = new ArrayList<>();
        routes.add("http://localhost:8080/user/getAll");
        return routes;
    }
}
