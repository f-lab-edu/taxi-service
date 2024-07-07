package com.giwankim.taxiservice.storage.redis.core;

import static com.giwankim.taxiservice.domain.Fixtures.aPickupRequest;
import static org.assertj.core.api.Assertions.assertThat;

import com.giwankim.taxiservice.core.domain.domain.PickupRequest;
import com.redis.testcontainers.RedisContainer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest
@Testcontainers
class PickupRequestPersistenceAdapterTest {
  @Container
  static RedisContainer redis =
      new RedisContainer(RedisContainer.DEFAULT_IMAGE_NAME.withTag(RedisContainer.DEFAULT_TAG));

  @DynamicPropertySource
  static void configureProperties(DynamicPropertyRegistry registry) {
    registry.add("storage.redis.core.host-name", redis::getRedisHost);
    registry.add("storage.redis.core.port", redis::getRedisPort);
  }

  @Autowired private PickupRequestPersistenceAdapter adapterUnderTest;

  @Autowired private PickupRequestRedisRepository pickupRequestRepository;

  @BeforeEach
  void setUp() {
    pickupRequestRepository.deleteAll();
  }

  @Test
  @DisplayName("배차 요청을 한다.")
  void storePickupRequest() {
    PickupRequest pickupRequest = aPickupRequest().id(null).build();

    PickupRequest storedPickupRequest = adapterUnderTest.storePickupRequest(pickupRequest, 60L);

    assertThat(storedPickupRequest.getId()).isNotNull();
    assertThat(pickupRequestRepository.existsById(storedPickupRequest.getId().value())).isTrue();
  }
}
