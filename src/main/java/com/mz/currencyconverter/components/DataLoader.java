package com.mz.currencyconverter.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.mz.currencyconverter.Constants;
import com.mz.currencyconverter.service.CurrencyService;

@Component
public class DataLoader implements ApplicationRunner {

	@Autowired
	CurrencyService currencyService;

    public void run(ApplicationArguments args) throws Exception {
		currencyService.createCurrency(Constants.CURRENCY_CODES[0]);
		currencyService.createCurrency(Constants.CURRENCY_CODES[1]);
		currencyService.createCurrency(Constants.CURRENCY_CODES[2]);
		currencyService.createCurrency(Constants.CURRENCY_CODES[3]);
		currencyService.createCurrency(Constants.CURRENCY_CODES[4]);
		currencyService.createCurrency(Constants.CURRENCY_CODES[5]);
	}
}
