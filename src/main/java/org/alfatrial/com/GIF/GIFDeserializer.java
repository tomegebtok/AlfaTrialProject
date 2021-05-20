package org.alfatrial.com.GIF;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

public class GIFDeserializer extends JsonDeserializer<GIFObject> {

    @Override
    public GIFObject deserialize(JsonParser parser, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonNode node = parser.getCodec().readTree(parser);
        node = node.get("data");
        return new GIFObject(node.get("image_original_url").textValue());
    }
}

