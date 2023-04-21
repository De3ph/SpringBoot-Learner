package com.example.demo.service.account;

import com.example.demo.service.account.request.RequestCreateAccount;
import com.example.demo.service.account.response.ResponseCreateAccount;
import com.example.demo.service.account.response.ResponseGetAccount;
import com.example.demo.service.account.response.ResponseGetAll;
import com.example.demo.service.account.response.ResponseGetAllSavingAccounts;

public interface IAccountService {
    ResponseGetAll getAll();
    ResponseGetAccount getAccount(Long id);
    ResponseGetAllSavingAccounts getAllSavingAccounts();
    ResponseCreateAccount createAccount(RequestCreateAccount request);

}
