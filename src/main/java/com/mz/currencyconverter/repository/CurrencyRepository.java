package com.mz.currencyconverter.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mz.currencyconverter.pojo.Currency;

@Repository
public interface CurrencyRepository extends CrudRepository<Currency, Long> {
    public Currency findByCode(String code);
}
