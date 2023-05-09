package com.example.demo.controller.user;

import com.example.demo.exception.user.UserNotFoundException;
import com.example.demo.service.user.UserService;
import com.example.demo.service.user.request.RequestDeleteUserById;
import com.example.demo.service.user.request.RequestGetUserById;
import com.example.demo.service.user.request.RequestUpdateUserEmail;
import com.example.demo.service.user.response.ResponseDeleteUser;
import com.example.demo.service.user.response.ResponseGetAll;
import com.example.demo.service.user.response.ResponseGetUser;
import com.example.demo.service.user.response.ResponseUpdateUserEmail;
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
        ResponseGetAll body = service.getAll();
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    // url de bilgiler gözükmesin diye post yapıyoruz
    @PostMapping(value = "/getUser")
    public ResponseEntity<ResponseGetUser> getUser(@RequestBody RequestGetUserById request)  {
        ResponseGetUser body = service.getUser(request.getId());
        return new ResponseEntity<>(body,HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteUser")
    public ResponseEntity<ResponseDeleteUser> deleteUser(@RequestBody RequestDeleteUserById request) throws UserNotFoundException {
        ResponseDeleteUser body = service.deleteUser(request.getId());
        return new ResponseEntity<>(body,HttpStatus.OK);
    }

    @PutMapping(value = "/updateUserEmail")
    public ResponseEntity<ResponseUpdateUserEmail> updateUserEmail(@RequestBody RequestUpdateUserEmail request) throws UserNotFoundException{
        ResponseUpdateUserEmail body = service.updateUserEmail(request.getId(), request.getEmail());
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

}
