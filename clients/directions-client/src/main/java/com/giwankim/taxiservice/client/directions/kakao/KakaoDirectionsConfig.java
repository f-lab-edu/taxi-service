package com.giwankim.taxiservice.client.directions.kakao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
class KakaoDirectionsConfig {
  @Value("${directions.kakao.api.key}")
  private String apiKey;

  @Value("${directions.kakao.api.url}")
  private String apiUrl;

  @Bean
  KakaoDirectionsApi kakaoDirectionsApi() {
    WebClient webClient =
        WebClient.builder()
            .baseUrl(apiUrl)
            .defaultHeader("Authorization", "KakaoAK " + apiKey)
            .build();
    WebClientAdapter adapter = WebClientAdapter.create(webClient);
    HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(adapter).build();
    return factory.createClient(KakaoDirectionsApi.class);
  }
}
