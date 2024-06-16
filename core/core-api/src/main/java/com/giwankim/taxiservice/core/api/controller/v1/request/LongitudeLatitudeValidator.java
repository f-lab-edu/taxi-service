package com.giwankim.taxiservice.core.api.controller.v1.request;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class LongitudeLatitudeValidator implements ConstraintValidator<LongitudeLatitude, String> {
  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    if (value == null) {
      return false;
    }
    String[] parts = value.split(",", 2);
    if (parts.length != 2) {
      return false;
    }
    try {
      double longitude = Double.parseDouble(parts[0]);
      double latitude = Double.parseDouble(parts[1]);
      return longitude >= -180 && longitude <= 180 && latitude >= -90 && latitude <= 90;
    } catch (NumberFormatException e) {
      return false;
    }
  }
}
