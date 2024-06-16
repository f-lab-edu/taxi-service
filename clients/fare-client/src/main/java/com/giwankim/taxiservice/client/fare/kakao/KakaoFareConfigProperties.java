package com.giwankim.taxiservice.client.fare.kakao;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@Configuration
@ConfigurationProperties(prefix = "fare.kakao")
@Getter
@Setter
public class KakaoFareConfigProperties {
  private Api api;

  @Getter
  @Setter
  @Validated
  public static class Api {
    @NotBlank private String key;
    @URL private String url;
  }
}
