package com.sellis.kafka.commons.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Description
 *
 * @author sellis
 */
public record TestPayload(@JsonProperty("message") String message,
                          @JsonProperty("identifier") long identifier) {

}
