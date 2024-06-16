package com.giwankim.taxiservice.client.directions.kakao;

import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@Configuration(proxyBeanMethods = false)
@ConfigurationProperties(prefix = "client.config.kakao-directions-api")
@Getter
@Setter
@Validated
public class KakaoDirectionsApiProperties {
  @PositiveOrZero private Integer connectTimeout;
  @PositiveOrZero private Integer readTimeout;
}
