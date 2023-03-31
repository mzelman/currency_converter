package com.mz.currencyconverter.components;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.mz.currencyconverter.service.CurrencyService;

@Component
public class ScheduledTask {

    CurrencyService currencyService;

	@Scheduled(cron = "0 0 12,13 * * MON-FRI")
	public void updateCurrencies() {
        currencyService.updateCurrencies();
	}
}