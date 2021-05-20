package org.alfatrial.com.currency;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "currency-api", url = "${currency.url}")
public interface CurrencyInterface {
    @GetMapping("/historical/{date}.json?app_id=${currency.api_id}")
    ResponseEntity<CurrencyObject> getCurrency(@PathVariable(value = "date") String date,
                                               @RequestParam(value = "base") String base);

}
