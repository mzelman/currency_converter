package com.mz.currencyconverter.pojo;

import java.util.Map;

public class CurrencyTable {
    private String table;
    private String no;
    private String effectiveDate;
    private Map<String, Object>[] rates;

    public CurrencyTable(String table, String no, String effectiveDate, Map<String, Object>[] rates) {
        this.table = table;
        this.no = no;
        this.effectiveDate = effectiveDate;
        this.rates = rates;
    }

    public CurrencyTable() {
    }

    public String getTable() {
        return this.table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getNo() {
        return this.no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getEffectiveDate() {
        return this.effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Map<String, Object>[] getRates() {
        return this.rates;
    }

    public void setRates(Map<String, Object>[] rates) {
        this.rates = rates;
    }

}
