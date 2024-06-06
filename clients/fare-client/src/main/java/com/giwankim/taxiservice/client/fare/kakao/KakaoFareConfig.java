package com.giwankim.taxiservice.client.fare.kakao;

import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableFeignClients
@Configuration
class KakaoFareConfig {
  @Value("${fare.kakao.api.key}")
  private String apiKey;

  @Bean
  RequestInterceptor requestInterceptor() {
    return requestTemplate -> requestTemplate.header("Authorization", "KakaoAK " + apiKey);
  }
}
