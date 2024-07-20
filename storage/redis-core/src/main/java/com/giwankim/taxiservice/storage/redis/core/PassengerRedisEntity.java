package com.giwankim.taxiservice.storage.redis.core;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class PassengerRedisEntity {
  private Long id;
  private String username;
  private String password;
  private String phoneNumber;

  @Builder
  public PassengerRedisEntity(Long id, String username, String password, String phoneNumber) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.phoneNumber = phoneNumber;
  }
}
