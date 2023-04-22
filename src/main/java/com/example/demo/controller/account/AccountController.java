package com.example.demo.controller.account;

import com.example.demo.service.account.AccountService;
import com.example.demo.service.account.request.RequestCreateAccount;
import com.example.demo.service.account.request.RequestDeleteAccount;
import com.example.demo.service.account.request.RequestGetAccountById;
import com.example.demo.service.account.response.*;
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
        ResponseGetAll body = service.getAll();
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    @PostMapping("/getAccount")
    public ResponseEntity<ResponseGetAccount> getAccount(@RequestBody RequestGetAccountById request) {
        ResponseGetAccount body = service.getAccount(request.getId());
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    @GetMapping("/getAllSavingAccounts")
    public ResponseEntity<ResponseGetAllSavingAccounts> getAllSavingAccounts() {
        ResponseGetAllSavingAccounts body = service.getAllSavingAccounts();
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    @PostMapping("/createAccount")
    public ResponseEntity<ResponseCreateAccount> createAccount(@RequestBody RequestCreateAccount request) {
        ResponseCreateAccount body = service.createAccount(request);
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    @PostMapping("/deleteAccount")
    public ResponseEntity<ResponseDeleteAccount> deleteAccount(@RequestBody RequestDeleteAccount request) {
        ResponseDeleteAccount body = service.deleteAccount(request);
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

}
