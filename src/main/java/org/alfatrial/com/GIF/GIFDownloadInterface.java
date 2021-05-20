package org.alfatrial.com.GIF;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.net.URI;

@Primary
@FeignClient(value = "download", url = "download")
public interface GIFDownloadInterface {
    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<byte[]> downloadByUrl(URI url);
}
