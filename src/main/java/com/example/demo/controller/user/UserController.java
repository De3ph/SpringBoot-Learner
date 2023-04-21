package com.example.demo.controller.user;

import com.example.demo.exception.user.UserNotFoundException;
import com.example.demo.service.user.UserService;
import com.example.demo.service.user.request.RequestDeleteUserById;
import com.example.demo.service.user.request.RequestGetUserById;
import com.example.demo.service.user.response.ResponseDeleteUser;
import com.example.demo.service.user.response.ResponseGetAll;
import com.example.demo.service.user.response.ResponseGetUser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        body.setUsers(service.getAll().getUsers());

        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    // url de bilgiler gözükmesin diye post yapıyoruz
    @PostMapping(value = "/getUser")
    public ResponseEntity<ResponseGetUser> getUser(@RequestBody RequestGetUserById request)  {
        ResponseGetUser body = new ResponseGetUser();
        body.setUser(service.getUser(request.getId()).getUser());

        return new ResponseEntity<>(body,HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteUser")
    public ResponseEntity<ResponseDeleteUser> deleteUser(@RequestBody RequestDeleteUserById request) throws UserNotFoundException {
        service.deleteUser(request.getId());
        return new ResponseEntity<>(new ResponseDeleteUser(HttpStatus.OK.value(), "User deleted successfully"), HttpStatus.OK);
    }

}
