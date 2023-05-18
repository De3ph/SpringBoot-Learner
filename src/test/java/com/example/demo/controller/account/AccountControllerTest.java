package com.example.demo.controller.account;


import com.example.demo.service.account.AccountService;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(MockitoJUnitRunner.class)
public class AccountControllerTest {

    private MockMvc mockMvc;

    private AccountController controller;

    @Mock
    private AccountService service;

    @Before
    public void setUp(){
        controller = new AccountController(service);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


}