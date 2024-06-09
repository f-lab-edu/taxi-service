package com.giwankim.taxiservice.client.directions.kakao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
class KakaoDirectionsConfig {
  @Bean
  public KakaoDirectionsApi kakaoDirectionsApi(KakaoDirectionsConfigProperties properties) {
    WebClient webClient =
        WebClient.builder()
            .baseUrl(properties.getApi().getUrl())
            .defaultHeader("Authorization", "KakaoAK " + properties.getApi().getKey())
            .build();
    WebClientAdapter adapter = WebClientAdapter.create(webClient);
    HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(adapter).build();
    return factory.createClient(KakaoDirectionsApi.class);
  }
}
