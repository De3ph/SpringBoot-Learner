package com.example.demo.controller.user;

import com.example.demo.controller.user.request.RequestGetUser;
import com.example.demo.controller.user.response.ResponseGetAll;
import com.example.demo.controller.user.response.ResponseGetUser;
import com.example.demo.dto.UserDTO;
import com.example.demo.service.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<ResponseGetAll> getAll(){
        ResponseGetAll body = new ResponseGetAll();
        body.setDtos(service.getAll());

        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    @PostMapping(value = "/getUser")
    public ResponseEntity<ResponseGetUser> getUser(@RequestBody RequestGetUser request){
        ResponseGetUser body = new ResponseGetUser();
        body.setDto(service.getUser(request.getId()));

        return new ResponseEntity<>(body,HttpStatus.OK);
    }

}
