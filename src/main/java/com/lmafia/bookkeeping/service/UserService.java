package com.lmafia.bookkeeping.service;

import com.lmafia.bookkeeping.codegen.tables.User;
import com.lmafia.bookkeeping.codegen.tables.records.UserRecord;
import jakarta.annotation.Resource;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;

/**
 * @author lmafia
 * @classname UserService.java
 * @description
 * @date 2023/4/4
 */
@Service
public class UserService {

    @Resource
    private DSLContext dslContext;

    public UserRecord getUserById(int userId) {
        return dslContext.selectFrom(User.USER)
            .where(User.USER.USER_ID.eq(userId))
            .fetchOne();
    }

    public void createUser(UserRecord user) {
        dslContext.insertInto(User.USER)
            .set(User.USER.USERNAME, user.getUsername())
            .set(User.USER.PASSWORD, user.getPassword())
            .set(User.USER.EMAIL, user.getEmail())
            .set(User.USER.CREATE_TIME, user.getCreateTime())
            .set(User.USER.UPDATE_TIME, user.getUpdateTime())
            .execute();
    }
}
