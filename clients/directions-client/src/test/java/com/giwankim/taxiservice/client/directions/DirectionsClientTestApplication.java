package com.giwankim.taxiservice.client.directions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class DirectionsClientTestApplication {
  public static void main(String[] args) {
    SpringApplication.run(DirectionsClientTestApplication.class, args);
  }
}
