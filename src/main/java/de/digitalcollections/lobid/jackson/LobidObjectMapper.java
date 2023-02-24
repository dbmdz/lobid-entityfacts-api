package de.digitalcollections.lobid.jackson;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class LobidObjectMapper extends ObjectMapper {
  public LobidObjectMapper() {
    super();

    // Both are needed to add `@context` to the top-level object
    disable(SerializationFeature.FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS);
    disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

    disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
    disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    // Don't include null properties
    setSerializationInclusion(JsonInclude.Include.NON_NULL);
  }
}
