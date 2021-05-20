
package org.alfatrial.com.GIF;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.URL;

@Primary
@FeignClient(name = "gif-api-var", url = "${gif.URL}")
public interface GIFGetterInterface {
    @GetMapping("/random?api_key=${gif.api_key}")
    ResponseEntity<GIFObject> getRandomGIFByTag(@RequestParam(value = "tag") String tag);
}

