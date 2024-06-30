package com.giwankim.taxiservice.core.api.support.masking;

@FunctionalInterface
public interface Masker {
  String mask(String value);
}
