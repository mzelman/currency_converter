package com.mz.currencyconverter.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mz.currencyconverter.pojo.Conversion;
import com.mz.currencyconverter.service.CurrencyService;


@Controller
public class CurrencyController {

    @Autowired
    CurrencyService currencyService;

@GetMapping("/")
public String main(Model model) {
    model.addAttribute("conversion", new Conversion());
    model.addAttribute("currencies", currencyService.getCurrencies());
    return "main";
}

@PostMapping("/convert")
public String convert(Model model, Conversion conversion, RedirectAttributes attributes) {
    if (conversion.getAmount() == null) {
        model.addAttribute("status", "failedAmount");
        model.addAttribute("conversion", conversion);
        model.addAttribute("currencies", currencyService.getCurrencies());
        return "main"; 
    }
    if (conversion.getCurrency() == null) {
        model.addAttribute("status", "failedCurrency");
        model.addAttribute("conversion", conversion);
        model.addAttribute("currencies", currencyService.getCurrencies());
        return "main";
    }
attributes.addFlashAttribute("convertedCurrencyAmount", conversion.getAmount());
attributes.addFlashAttribute("convertedCurrencyCode", conversion.getCurrency().getCode());
attributes.addFlashAttribute("status", "success");
attributes.addFlashAttribute("result", currencyService.convertCurrency(conversion));
return "redirect:/";
}

}

