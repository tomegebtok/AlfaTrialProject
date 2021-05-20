package org.alfatrial.com.currency;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CurrencyComparisonService {
    CurrencyService currencyService;
    @Value("${currency.code}")
    String currencyCode;

    public CurrencyComparisonService(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    public int compareCurrenciesByDate(String today, String yesterday, String base) {
        return Double.compare(getRate(today, base), getRate(yesterday, base));
    }

    public double getRate(String date, String base) {
        return currencyService.getCurrency(date, base).getBody().getExchangeRates().get(currencyCode);
    }
}
