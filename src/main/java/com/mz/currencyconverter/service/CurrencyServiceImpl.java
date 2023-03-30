package com.mz.currencyconverter.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mz.currencyconverter.pojo.Conversion;
import com.mz.currencyconverter.pojo.Currency;
import com.mz.currencyconverter.pojo.CurrencyTable;
import com.mz.currencyconverter.repository.CurrencyRepository;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    @Autowired
    CurrencyRepository currencyRepository;
     
    public List<Currency> getCurrencies() {
        return (List<Currency>)currencyRepository.findAll();
    }

    public BigDecimal convertCurrency(Conversion conversion) {
        BigDecimal result = conversion.getCurrency().getRate().multiply(conversion.getAmount());
        return result.setScale(2, RoundingMode.HALF_UP);
    }

    public Map<String, Object>[] getRates() {
        try {
            URL url = new URL("http://api.nbp.pl/api/exchangerates/tables/a/today/?format=json");
                ObjectMapper mapper = new ObjectMapper();
                CurrencyTable[] currencyTables = mapper.readValue(url, CurrencyTable[].class);
                CurrencyTable currencyTable = currencyTables[0];
                Map<String, Object>[] rates = currencyTable.getRates();
                return rates;
         } catch (Exception e) {
            return null;
         }
        }

        public void createCurrency(String code) {
                Map<String, Object>[] rates = getRates();
                Currency currency = null;
                for (int i = 0; i < rates.length; i++) {
                    if (rates[i].get("code").toString().equals(code)) {
                        currency = new Currency(rates[i].get("currency").toString(), rates[i].get("code").toString(), new BigDecimal(rates[i].get("mid").toString()));
                    }
                }
                currencyRepository.save(currency);
        }

}
