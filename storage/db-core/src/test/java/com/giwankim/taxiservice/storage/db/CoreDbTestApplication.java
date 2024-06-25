package com.giwankim.taxiservice.storage.db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class CoreDbTestApplication {
  public static void main(String[] args) {
    SpringApplication.run(CoreDbTestApplication.class, args);
  }
}
