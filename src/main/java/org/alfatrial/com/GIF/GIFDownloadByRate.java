package org.alfatrial.com.GIF;

import org.alfatrial.com.currency.CurrencyComparisonService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;

@Service
public class GIFDownloadByRate {
    CurrencyComparisonService currencyComparisonService;
    GIFGetterService gifService;
    GIFDownloadService gifDownloadService;
    @Value("${currency.code_to_compare}")
    String currencyCodeToCompare;
    @Value("${currency.code}")
    String currencyCode;

    public GIFDownloadByRate(CurrencyComparisonService currencyComparisonService, GIFGetterService gifService, GIFDownloadService gifDownloadService) {
        this.currencyComparisonService = currencyComparisonService;
        this.gifDownloadService = gifDownloadService;
        this.gifService = gifService;
    }

    public ResponseEntity<byte[]> downloadGIFByURL() throws MalformedURLException, IOException, URISyntaxException {
        String tag = currencyComparisonService.compareCurrenciesByDate(LocalDate.now().toString(), LocalDate.now().minusDays(1).toString(), currencyCodeToCompare) > 0 ? "rich" : "broke";
        if (currencyComparisonService.compareCurrenciesByDate(LocalDate.now().toString(), LocalDate.now().minusDays(1).toString(), currencyCodeToCompare) == 0)
            tag = "equals";
        URI url = new URI(gifService.getRandomGIFByTag(tag).getBody().getURL_name());

        return gifDownloadService.downloadByUrl(url);
    }
}


