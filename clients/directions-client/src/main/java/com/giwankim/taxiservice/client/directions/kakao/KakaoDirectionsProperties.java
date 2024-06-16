package com.giwankim.taxiservice.client.directions.kakao;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@Configuration(proxyBeanMethods = false)
@ConfigurationProperties(prefix = "directions.kakao")
@Getter
@Setter
public class KakaoDirectionsProperties {
  private Api api;

  @Getter
  @Setter
  @Validated
  public static class Api {
    @NotEmpty private String key;
    @URL private String url;
  }
}
