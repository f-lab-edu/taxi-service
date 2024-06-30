package com.giwankim.taxiservice.core.api.support.masking;

import java.util.regex.Pattern;

public class PhoneMasker implements Masker {
  private static final Pattern HYPEN_SEPARATED_PATTERN =
      Pattern.compile("^(\\d{2,3})-(\\d{3,4})-(\\d{4})");
  private static final Pattern SEOUL_PHONE_NUMBER_PATTERN =
      Pattern.compile("^02(\\d{3,4})(\\d{4})");
  private static final Pattern PHONE_NUMBER_PATTERN =
      Pattern.compile("^(\\d{3})(\\d{3,4})(\\d{4})");

  @Override
  public String mask(String phoneNumber) {
    if (isHyphenSeparated(phoneNumber)) {
      return maskHyphenSeparated(phoneNumber);
    }
    if (isSeoulPhoneNumber(phoneNumber)) {
      return maskSeoulPhoneNumber(phoneNumber);
    }
    return maskPhoneNumber(phoneNumber);
  }

  private static boolean isHyphenSeparated(String phoneNumber) {
    return HYPEN_SEPARATED_PATTERN.matcher(phoneNumber).matches();
  }

  private String maskHyphenSeparated(String phoneNumber) {
    return HYPEN_SEPARATED_PATTERN
        .matcher(phoneNumber)
        .replaceAll(m -> m.group(1) + "-" + maskAll(m.group(2)) + "-" + m.group(3));
  }

  private static boolean isSeoulPhoneNumber(String phoneNumber) {
    return SEOUL_PHONE_NUMBER_PATTERN.matcher(phoneNumber).matches();
  }

  private String maskSeoulPhoneNumber(String phoneNumber) {
    return SEOUL_PHONE_NUMBER_PATTERN
        .matcher(phoneNumber)
        .replaceAll(m -> "02" + maskAll(m.group(1)) + m.group(2));
  }

  private static String maskPhoneNumber(String phoneNumber) {
    return PHONE_NUMBER_PATTERN
        .matcher(phoneNumber)
        .replaceAll(m -> m.group(1) + maskAll(m.group(2)) + m.group(3));
  }

  private static String maskAll(String str) {
    return str.replaceAll(".", "*");
  }
}
