package com.giwankim.taxiservice.storage.redis.core.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class CoreRedisConfig {
  @Bean
  @ConfigurationProperties(prefix = "storage.redis.core")
  public RedisConfiguration coreRedisConfiguration() {
    return new RedisStandaloneConfiguration();
  }

  @Bean
  public LettuceConnectionFactory redisConnectionFactory(
      @Qualifier("coreRedisConfiguration") RedisConfiguration redisConfiguration) {
    return new LettuceConnectionFactory(redisConfiguration);
  }

  @Bean
  public RedisTemplate<?, ?> redisTemplate(RedisConnectionFactory connectionFactory) {
    RedisTemplate<byte[], byte[]> redisTemplate = new RedisTemplate<>();
    redisTemplate.setConnectionFactory(connectionFactory);
    return redisTemplate;
  }
}
