package org.alfatrial.com.GIF;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GIFGetterService implements GIFGetterInterface {

    private final GIFGetterInterface GIFGetterInterface;

    public GIFGetterService(GIFGetterInterface GIFGetterInterface) {
        this.GIFGetterInterface = GIFGetterInterface;
    }

    @Override
    public ResponseEntity<GIFObject> getRandomGIFByTag(String tag) {
        return GIFGetterInterface.getRandomGIFByTag(tag);
    }
}
