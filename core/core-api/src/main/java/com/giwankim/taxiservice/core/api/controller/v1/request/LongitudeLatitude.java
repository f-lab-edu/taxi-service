package com.giwankim.taxiservice.core.api.controller.v1.request;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = LongitudeLatitudeValidator.class)
@Documented
public @interface LongitudeLatitude {
  String message() default "Invalid location format. Expected format: origin=longitude,latitude";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
