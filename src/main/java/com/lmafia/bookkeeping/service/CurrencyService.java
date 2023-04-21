package com.lmafia.bookkeeping.service;

import com.lmafia.bookkeeping.codegen.tables.records.CurrencyRecord;
import jakarta.annotation.Resource;
import org.jooq.DSLContext;

import java.util.List;

import static com.lmafia.bookkeeping.codegen.Tables.CURRENCY;

/**
 * @author lmafia
 * @classname CurrencyService.java
 * @description
 * @date 2023/4/12
 */
public class CurrencyService {

    @Resource
    private DSLContext dslContext;

    public CurrencyRecord getCurrencyById(int id) {
        return dslContext.selectFrom(CURRENCY)
                .where(CURRENCY.CURRENCY_ID.eq(id))
                .fetchOne();
    }

    public List<CurrencyRecord> getAllCurrencies() {
        return dslContext.selectFrom(CURRENCY)
                .fetch();
    }

    public void createCurrency(CurrencyRecord currency) {
        dslContext.insertInto(CURRENCY)
                .set(CURRENCY.NAME, currency.getName())
                .set(CURRENCY.RATE, currency.getRate())
                .set(CURRENCY.SYMBOL, currency.getSymbol())
                .execute();

    }

    public void updateCurrency(CurrencyRecord currency) {
        dslContext.update(CURRENCY)
                .set(CURRENCY.NAME, currency.getName())
                .set(CURRENCY.RATE, currency.getRate())
                .set(CURRENCY.SYMBOL, currency.getSymbol())
                .where(CURRENCY.CURRENCY_ID.eq(currency.getCurrencyId()))
                .execute();
    }

    public void deleteCurrencyById(int id) {
        dslContext.delete(CURRENCY)
                .where(CURRENCY.CURRENCY_ID.eq(id))
                .execute();
    }

}
