package com.giwankim.taxiservice.client.fare.kakao;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "fare.kakao")
@Getter
@Setter
public class KakaoFareConfigProperties {
  @NotBlank private String apiKey;
  @NotBlank private String apiUrl;
}
