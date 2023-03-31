package com.mz.currencyconverter.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.mz.currencyconverter.service.CurrencyService;

@Component
public class DataLoader implements ApplicationRunner {

	@Autowired
	CurrencyService currencyService;

    public void run(ApplicationArguments args) throws Exception {
		currencyService.createCurrencies();
	}
}
