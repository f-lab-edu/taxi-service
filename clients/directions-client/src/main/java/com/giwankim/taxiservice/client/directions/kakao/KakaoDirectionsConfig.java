package com.giwankim.taxiservice.client.directions.kakao;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import java.util.concurrent.TimeUnit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import reactor.netty.http.client.HttpClient;

@Configuration
class KakaoDirectionsConfig {
  @Bean
  public KakaoDirectionsApi kakaoDirectionsApi(HttpServiceProxyFactory factory) {
    return factory.createClient(KakaoDirectionsApi.class);
  }

  @Bean
  public HttpServiceProxyFactory httpServiceProxyFactory(WebClient webClient) {
    WebClientAdapter adapter = WebClientAdapter.create(webClient);
    return HttpServiceProxyFactory.builderFor(adapter).build();
  }

  @Bean
  public WebClient webClient(HttpClient httpClient, KakaoDirectionsProperties properties) {
    return WebClient.builder()
        .clientConnector(new ReactorClientHttpConnector(httpClient))
        .baseUrl(properties.getApi().getUrl())
        .defaultHeader("Authorization", "KakaoAK " + properties.getApi().getKey())
        .build();
  }

  @Bean
  public HttpClient httpClient(KakaoDirectionsApiProperties apiProperties) {
    return HttpClient.create()
        .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, apiProperties.getConnectTimeout())
        .doOnConnected(
            conn ->
                conn.addHandlerLast(
                    new ReadTimeoutHandler(apiProperties.getReadTimeout(), TimeUnit.MILLISECONDS)));
  }
}
