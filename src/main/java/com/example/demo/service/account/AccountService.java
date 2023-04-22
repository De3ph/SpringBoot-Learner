package com.example.demo.service.account;

import com.example.demo.dto.AccountDTO;
import com.example.demo.entity.Account;
import com.example.demo.enums.EnumAccountType;
import com.example.demo.enums.EnumSuccessType;
import com.example.demo.exception.account.AccountNotFoundException;
import com.example.demo.mapper.AccountMapper;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.account.request.RequestCreateAccount;
import com.example.demo.service.account.request.RequestDeleteAccount;
import com.example.demo.service.account.response.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@Service
public class AccountService implements IAccountService {

    private final AccountRepository repository;
    private final UserRepository userRepository;
    private final Logger logger = Logger.getLogger(AccountService.class.getName());

    public AccountService(AccountRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
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
        repository.findAllByAccountType(EnumAccountType.SAVINGS).forEach(account -> {
            dtos.add(AccountMapper.INSTANCE.toDTO(account, account.getUser()));
            logger.info("ACCOUNT MAPPED SUCCESSFULLY TO DTO. AccountDTO: " + dtos.get(dtos.size() - 1));
        });
        response.setDtos(dtos);
        return response;
    }

    @Override
    public ResponseCreateAccount createAccount(RequestCreateAccount request) {
        ResponseCreateAccount response = new ResponseCreateAccount();
        AccountDTO dto = new AccountDTO();
        dto.setBalance(request.getBalance());
        dto.setName(request.getName());
        dto.setOwnerName(userRepository.findById(request.getUserId()).get().getUsername());
        dto.setType(request.getType());
        Account account = AccountMapper.INSTANCE.toEntity(dto);
        account.setCreatedAt(new Date());
        account.setUpdatedAt(new Date());
        account.setUser(userRepository.findById(request.getUserId()).get());
        response.setDto(AccountMapper.INSTANCE.toDTO(repository.save(account), account.getUser()));
        logger.fine("ACCOUNT CREATED SUCCESSFULLY. AccountDTO: " + response.getDto());
        return response;
    }

    @Override
    public ResponseDeleteAccount deleteAccount(RequestDeleteAccount request) throws AccountNotFoundException {
        ResponseDeleteAccount response = new ResponseDeleteAccount();
        Account account = repository.findById(request.getId()).orElseThrow(() -> new AccountNotFoundException("Account not found", "/service/account", ""));
        repository.delete(account);
        response.setSuccessType(EnumSuccessType.SUCCESS);
        logger.fine("ACCOUNT DELETED SUCCESSFULLY. AccountId: " + request.getId());
        return response;
    }
}
