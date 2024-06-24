package com.giwankim.taxiservice.storage.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class CoreRedisTestApplication {
  public static void main(String[] args) {
    SpringApplication.run(CoreRedisTestApplication.class, args);
  }
}
