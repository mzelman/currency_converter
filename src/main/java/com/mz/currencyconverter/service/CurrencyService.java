package com.mz.currencyconverter.service;

import java.math.BigDecimal;
import java.util.List;

import com.mz.currencyconverter.pojo.Conversion;
import com.mz.currencyconverter.pojo.Currency;

public interface CurrencyService {
    public List<Currency> getCurrencies();
    public BigDecimal convertCurrency(Conversion conversion);
    public void createCurrency(String code);
}
