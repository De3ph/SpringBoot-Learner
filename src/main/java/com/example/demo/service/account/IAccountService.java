package com.example.demo.service.account;

import com.example.demo.service.account.request.RequestCreateAccount;
import com.example.demo.service.account.request.RequestDeleteAccount;
import com.example.demo.service.account.response.*;

public interface IAccountService {
    ResponseGetAll getAll();
    ResponseGetAccount getAccount(Long id);
    ResponseGetAllSavingAccounts getAllSavingAccounts();
    ResponseCreateAccount createAccount(RequestCreateAccount request);
    ResponseDeleteAccount deleteAccount(RequestDeleteAccount request);
}
