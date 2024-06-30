package com.giwankim.taxiservice.core.api.support.masking;

import java.util.regex.Pattern;

public class NameMasker implements Masker {
  @Override
  public String mask(String name) {
    if (isKoreanName(name)) {
      return switch (name.length()) {
        case 2 -> name.replaceAll("([가-힣])([가-힣]+)", "$1*");
        default -> maskExceptForEdge(name, 1);
      };
    }

    if (name.length() < 3) {
      return name;
    }

    int unmaskedSideSize = name.length() < 6 ? 1 : 2;
    return maskExceptForEdge(name, unmaskedSideSize);
  }

  private static String maskExceptForEdge(String text, int edgeSize) {
    String prefix = text.substring(0, edgeSize);
    String middle =
        text.substring(edgeSize, text.length() - edgeSize).replaceAll("[a-zA-Z가-힣]", "*");
    String suffix = text.substring(text.length() - edgeSize);
    return prefix + middle + suffix;
  }

  private static boolean isKoreanName(String name) {
    return Pattern.compile("[가-힣]{2,}").matcher(name).matches();
  }
}
