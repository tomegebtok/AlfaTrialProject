package org.alfatrial.com.currency;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CurrencyComparisonServiceTest {
    @Autowired
    private CurrencyService currencyService;

    @Test
    public void getCurrency() {
        assertAll(
                () -> assertNotEquals(currencyService.getCurrency(LocalDate.now().toString(), "USD").getBody().getExchangeRates().get("RUB"), currencyService.getCurrency(LocalDate.now().minusDays(1).toString(), "USD").getBody().getExchangeRates().get("RUB"))
        );
    }
}