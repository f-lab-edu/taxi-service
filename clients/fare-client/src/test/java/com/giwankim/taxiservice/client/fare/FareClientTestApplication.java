package com.giwankim.taxiservice.client.fare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class FareClientTestApplication {
  public static void main(String[] args) {
    SpringApplication.run(FareClientTestApplication.class, args);
  }
}
