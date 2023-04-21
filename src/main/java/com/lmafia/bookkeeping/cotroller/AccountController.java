package com.lmafia.bookkeeping.cotroller;

import com.lmafia.bookkeeping.codegen.tables.records.AccountRecord;
import com.lmafia.bookkeeping.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author lmafia
 * @classname AccountController.java
 * @description
 * @date 2023/4/12
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @Resource
    AccountService accountService;

    @GetMapping("/all")
    public ResponseEntity<List<AccountRecord>> getAll() {
        List<AccountRecord> allAccounts = accountService.getAllAccounts();
        return new ResponseEntity<>(allAccounts, HttpStatus.OK);
    }
}
