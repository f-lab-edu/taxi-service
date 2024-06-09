package com.giwankim.taxiservice.client.fare.kakao;

import feign.RequestInterceptor;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableFeignClients
@Configuration
class KakaoFareConfig {
  @Bean
  public RequestInterceptor requestInterceptor(KakaoFareConfigProperties properties) {
    return requestTemplate ->
        requestTemplate.header("Authorization", "KakaoAK " + properties.getApi().getKey());
  }
}
