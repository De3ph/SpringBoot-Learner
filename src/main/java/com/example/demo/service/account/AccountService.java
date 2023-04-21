package com.example.demo.service.account;

import com.example.demo.dto.AccountDTO;
import com.example.demo.entity.Account;
import com.example.demo.enums.AccountType;
import com.example.demo.exception.account.AccountNotFoundException;
import com.example.demo.mapper.AccountMapper;
import com.example.demo.repository.AccountRepository;
import com.example.demo.service.account.request.RequestCreateAccount;
import com.example.demo.service.account.response.ResponseCreateAccount;
import com.example.demo.service.account.response.ResponseGetAccount;
import com.example.demo.service.account.response.ResponseGetAll;
import com.example.demo.service.account.response.ResponseGetAllSavingAccounts;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class AccountService implements IAccountService {

    private final AccountRepository repository;
    private final Logger logger = Logger.getLogger(AccountService.class.getName());

    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public ResponseGetAll getAll() {
        ResponseGetAll response = new ResponseGetAll();
        List<AccountDTO> dtos = new ArrayList<>();
        repository.findAll().forEach(account -> {
                    AccountDTO dto = AccountMapper.INSTANCE.toDTO(account, account.getUser());
                    if (dto != null) {
                        dtos.add(dto);
                        logger.info("ACCOUNT MAPPED SUCCESSFULLY TO DTO. AccountDTO: " + dto);
                    }
                }
        );
        response.setDtos(dtos);
        return response;
    }

    @Override
    public ResponseGetAccount getAccount(Long id) throws AccountNotFoundException {
        ResponseGetAccount response = new ResponseGetAccount();
        Account account = repository.findById(id).orElseThrow(() -> new AccountNotFoundException("Account not found", "/service/account", ""));
        AccountDTO dto = AccountMapper.INSTANCE.toDTO(account, account.getUser());
        if (dto != null) {
            logger.info("ACCOUNT MAPPED SUCCESSFULLY TO DTO. AccountDTO: " + dto);
        }

        response.setDto(dto);
        return response;
    }

    @Override
    public ResponseGetAllSavingAccounts getAllSavingAccounts() {
        ResponseGetAllSavingAccounts response = new ResponseGetAllSavingAccounts();
        ArrayList<AccountDTO> dtos = new ArrayList<>();
        repository.findAllByAccountType(AccountType.SAVINGS).forEach(account -> {
            dtos.add(AccountMapper.INSTANCE.toDTO(account, account.getUser()));
            logger.info("ACCOUNT MAPPED SUCCESSFULLY TO DTO. AccountDTO: " + dtos.get(dtos.size() - 1));
        });
        response.setDtos(dtos);
        return response;
    }

    @Override
    public ResponseCreateAccount createAccount(RequestCreateAccount request) {
        return null;
    }
}
