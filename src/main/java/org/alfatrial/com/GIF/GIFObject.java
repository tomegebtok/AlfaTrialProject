package org.alfatrial.com.GIF;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


@JsonDeserialize(using = GIFDeserializer.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GIFObject {

    private String URL_name;

    public GIFObject(String URL_name) {
        this.URL_name = URL_name;
    }

    @Override
    public String toString() {
        return "GIFObject{" +
                "URL_name='" + URL_name + '\'' +
                '}';
    }

    public String getURL_name() {
        return URL_name;
    }

}
