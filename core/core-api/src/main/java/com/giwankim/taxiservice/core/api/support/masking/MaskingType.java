package com.giwankim.taxiservice.core.api.support.masking;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum MaskingType {
  NAME(new NameMasker()),
  PHONE_NUMBER(new PhoneMasker());

  private final Masker masker;
}
