package com.lmafia.bookkeeping.service;

import com.lmafia.bookkeeping.codegen.tables.records.AccountRecord;
import jakarta.annotation.Resource;

import java.util.List;

import org.jooq.DSLContext;
import org.springframework.stereotype.Service;

import static com.lmafia.bookkeeping.codegen.tables.Account.ACCOUNT;

/**
 * @author lmafia
 * @classname AccountService.java
 * @description
 * @date 2023/4/4
 */
@Service
public class AccountService {

    @Resource
    private DSLContext dslContext;

    public AccountRecord getAccountById(int id) {
        return dslContext.selectFrom(ACCOUNT)
                .where(ACCOUNT.ACCOUNT_ID.eq(id))
                .fetchOne();
    }

    public List<AccountRecord> getAllAccounts() {
        return dslContext.selectFrom(ACCOUNT)
                .fetch();
    }

    public void createAccount(AccountRecord account) {
        dslContext.insertInto(ACCOUNT)
                .set(ACCOUNT.NAME, account.getName())
                .set(ACCOUNT.TYPE, account.getType())
                .set(ACCOUNT.BALANCE, account.getBalance())
                .execute();
    }

    public void updateAccount(AccountRecord account) {
        dslContext.update(ACCOUNT)
                .set(ACCOUNT.NAME, account.getName())
                .set(ACCOUNT.TYPE, account.getType())
                .set(ACCOUNT.BALANCE, account.getBalance())
                .where(ACCOUNT.ACCOUNT_ID.eq(account.getAccountId()))
                .execute();
    }

    public void deleteAccount(int id) {
        dslContext.deleteFrom(ACCOUNT)
                .where(ACCOUNT.ACCOUNT_ID.eq(id))
                .execute();
    }
}

