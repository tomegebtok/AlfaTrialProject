package org.alfatrial.com.GIF;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;

@Service
public class GIFDownloadService implements GIFDownloadInterface {

    private final GIFDownloadInterface gifDownloadInterface;

    public GIFDownloadService(GIFDownloadInterface gifDownloadInterface) {
        this.gifDownloadInterface = gifDownloadInterface;
    }

    @Override
    public ResponseEntity<byte[]> downloadByUrl(URI url) {
        return gifDownloadInterface.downloadByUrl(url);
    }
}
