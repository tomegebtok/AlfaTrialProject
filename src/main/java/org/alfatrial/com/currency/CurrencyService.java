package org.alfatrial.com.currency;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class CurrencyService implements CurrencyInterface {
    private final CurrencyInterface currencyInterface;

    public CurrencyService(CurrencyInterface currencyInterface) {
        this.currencyInterface = currencyInterface;
    }

    @Override
    public ResponseEntity<CurrencyObject> getCurrency(String date, String base) {
        return currencyInterface.getCurrency(date, base);
    }
}
