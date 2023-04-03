package com.lmafia.bookkeeping.service;

import com.lmafia.bookkeeping.codegen.Tables;
import com.lmafia.bookkeeping.codegen.tables.records.AccountRecord;
import jakarta.annotation.Resource;
import java.util.List;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;

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
        return dslContext.selectFrom(Tables.ACCOUNT)
            .where(Tables.ACCOUNT.ACCOUNT_ID.eq(id))
            .fetchOne();
    }

    public List<AccountRecord> getAllAccounts() {
        return dslContext.selectFrom(Tables.ACCOUNT)
            .fetch();
    }

    public void createAccount(AccountRecord account) {
        dslContext.insertInto(Tables.ACCOUNT)
            .set(Tables.ACCOUNT.USER_ID, account.getUserId())
            .set(Tables.ACCOUNT.NAME, account.getName())
            .set(Tables.ACCOUNT.TYPE, account.getType())
            .set(Tables.ACCOUNT.BALANCE, account.getBalance())
            .execute();
    }

    public void updateAccount(AccountRecord account) {
        dslContext.update(Tables.ACCOUNT)
            .set(Tables.ACCOUNT.NAME, account.getName())
            .set(Tables.ACCOUNT.TYPE, account.getType())
            .set(Tables.ACCOUNT.BALANCE, account.getBalance())
            .where(Tables.ACCOUNT.ACCOUNT_ID.eq(account.getAccountId()))
            .execute();
    }

    public void deleteAccount(int id) {
        dslContext.deleteFrom(Tables.ACCOUNT)
            .where(Tables.ACCOUNT.ACCOUNT_ID.eq(id))
            .execute();
    }
}

