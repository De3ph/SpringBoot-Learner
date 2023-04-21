package com.example.demo.controller.account;

import com.example.demo.service.account.AccountService;
import com.example.demo.service.account.request.RequestCreateAccount;
import com.example.demo.service.account.request.RequestGetAccountById;
import com.example.demo.service.account.response.ResponseCreateAccount;
import com.example.demo.service.account.response.ResponseGetAccount;
import com.example.demo.service.account.response.ResponseGetAll;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }


    @GetMapping("/getAll")
    public ResponseEntity<ResponseGetAll> getAll() {
        ResponseGetAll body = new ResponseGetAll();
        body.setDtos(service.getAll().getDtos());
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    @PostMapping("/getAccount")
    public ResponseEntity<ResponseGetAccount> getAccount(@RequestBody RequestGetAccountById request) {
        ResponseGetAccount body = new ResponseGetAccount();
        body.setDto(service.getAccount(request.getId()).getDto());
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    @PostMapping("/createAccount")
    public ResponseEntity<ResponseCreateAccount> createAccount(@RequestBody RequestCreateAccount request) {
        ResponseCreateAccount body = new ResponseCreateAccount();
        body.setDto(service.createAccount(request).getDto());
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

}
