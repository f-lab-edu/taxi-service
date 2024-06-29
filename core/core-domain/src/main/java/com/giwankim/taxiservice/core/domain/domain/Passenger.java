package com.giwankim.taxiservice.core.domain.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Passenger {
  private final PassengerId id;
  private final String username;
  private final String password;
  private final String phoneNumber;

  @Builder
  public Passenger(PassengerId id, String username, String password, String phoneNumber) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.phoneNumber = phoneNumber;
  }

  public record PassengerId(Long value) {}
}
