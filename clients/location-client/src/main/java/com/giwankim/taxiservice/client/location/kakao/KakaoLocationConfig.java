package com.giwankim.taxiservice.client.location.kakao;

import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableFeignClients
@Configuration
class KakaoLocationConfig {

  @Value("${location.kakao.api.key}")
  private String apiKey;

  @Bean
  public RequestInterceptor kakaoLocationRequestInterceptor() {
    return requestTemplate -> requestTemplate.header("Authorization", "KakaoAK " + apiKey);
  }
}
