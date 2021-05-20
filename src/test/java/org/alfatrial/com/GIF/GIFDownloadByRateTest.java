package org.alfatrial.com.GIF;

import org.alfatrial.com.currency.CurrencyComparisonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
class GIFDownloadByRateTest {
    @Autowired
    CurrencyComparisonService currencyComparisonService;
    @Autowired
    GIFGetterService gifService;
    @Autowired
    GIFDownloadService gifDownloadService;

    @Test
    public void downloadGIFByURL() throws URISyntaxException {
        URI url = new URI(gifService.getRandomGIFByTag("rich").getBody().getURL_name());
        ResponseEntity<byte[]> rich = gifDownloadService.downloadByUrl(url);
        url = new URI(gifService.getRandomGIFByTag("broke").getBody().getURL_name());
        ResponseEntity<byte[]> broke = gifDownloadService.downloadByUrl(url);
        assertAll(
                () -> assertNotEquals(rich, broke)
        );

    }
}