package org.alfatrial.com;

import org.alfatrial.com.GIF.GIFDownloadByRate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;

@RestController
@RequestMapping(path = "/gif", produces = "image/gif")
public class MainAppController {

    private GIFDownloadByRate gifDownloadByRate;

    public MainAppController(GIFDownloadByRate gifDownloadByRate) {
        this.gifDownloadByRate = gifDownloadByRate;
    }

    @GetMapping
    public ResponseEntity<byte[]> getGIF() throws IOException, URISyntaxException {
        return gifDownloadByRate.downloadGIFByURL();
    }
}