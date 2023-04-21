package com.lmafia.bookkeeping.service;

import com.lmafia.bookkeeping.codegen.tables.records.TagRecord;
import jakarta.annotation.Resource;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.lmafia.bookkeeping.codegen.Tables.TAG;

/**
 * @author lmafia
 * @classname TagService.java
 * @description
 * @date 2023/4/12
 */
@Service
public class TagService {
    @Resource
    DSLContext dslContext;

    List<TagRecord> getTags() {
        return dslContext.selectFrom(TAG).fetch();
    }


}
