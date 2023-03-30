package com.mz.currencyconverter.components;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.mz.currencyconverter.Constants;
import com.mz.currencyconverter.service.CurrencyService;

@Component
public class ScheduledTask {

    CurrencyService currencyService;

	@Scheduled(cron = "0 0 12,13 * * MON-FRI")
	public void updateCurrencies() {
        currencyService.createCurrency(Constants.CURRENCY_CODES[0]);
		currencyService.createCurrency(Constants.CURRENCY_CODES[1]);
		currencyService.createCurrency(Constants.CURRENCY_CODES[2]);
		currencyService.createCurrency(Constants.CURRENCY_CODES[3]);
		currencyService.createCurrency(Constants.CURRENCY_CODES[4]);
		currencyService.createCurrency(Constants.CURRENCY_CODES[5]);
	}
}