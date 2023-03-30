package com.mz.currencyconverter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.mz.currencyconverter.pojo.Conversion;
import com.mz.currencyconverter.pojo.Currency;
import com.mz.currencyconverter.repository.CurrencyRepository;
import com.mz.currencyconverter.service.CurrencyServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class CurrencyServiceTest {
   
    @Mock
    CurrencyRepository currencyRepository;

    @InjectMocks
    CurrencyServiceImpl currencyService;
    
    Currency currency = new Currency("Dolar", Constants.CURRENCY_CODES[0], new BigDecimal("4.53"));
    Conversion conversion = new Conversion(currency, new BigDecimal("7.65"));

    @Test
    public void convertCurencyTest() {
        assertEquals(new BigDecimal("34.65"), currencyService.convertCurrency(conversion));
    }

}
