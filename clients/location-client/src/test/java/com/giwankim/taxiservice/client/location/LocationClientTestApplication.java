package com.giwankim.taxiservice.client.location;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class LocationClientTestApplication {

  public static void main(String[] args) {
    SpringApplication.run(LocationClientTestApplication.class, args);
  }
}
