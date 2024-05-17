package com.giwankim.taxiservice.client.location;

import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableFeignClients
@Configuration
public class LocationConfig {

  @Value("${location.kakao.api.key}")
  private String apiKey;

  @Bean
  public RequestInterceptor requestInterceptor() {
    return requestTemplate -> requestTemplate.header("Authorization", "KakaoAK " + apiKey);
  }
}
