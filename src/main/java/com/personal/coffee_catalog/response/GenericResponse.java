package com.personal.coffee_catalog.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class GenericResponse<T> {

  public static final String OK_MESSAGE = "OK";
  public static final String TIMEOUT_MESSAGE = "TIMEOUT";
  public static final String DUPLICATE_MESSAGE = "DUPLICATE";

  @JsonProperty("data")
  private T data;

  @JsonIgnore
  @Builder.Default
  Throwable exception = null;

  @JsonProperty("message")
  @Builder.Default
  private String message = OK_MESSAGE;
}
