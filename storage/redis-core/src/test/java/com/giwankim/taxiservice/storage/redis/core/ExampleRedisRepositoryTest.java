package com.giwankim.taxiservice.storage.redis.core;

import static org.assertj.core.api.Assertions.assertThat;

import com.redis.testcontainers.RedisContainer;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest
@Testcontainers
class ExampleRedisRepositoryTest {
  @Container
  static final RedisContainer redis =
      new RedisContainer(RedisContainer.DEFAULT_IMAGE_NAME.withTag(RedisContainer.DEFAULT_TAG));

  @DynamicPropertySource
  static void configureProperties(DynamicPropertyRegistry registry) {
    registry.add("storage.redis.core.host-name", redis::getRedisHost);
    registry.add("storage.redis.core.port", redis::getRedisPort);
  }

  @Autowired private ExampleRedisRepository exampleRedisRepository;

  @AfterEach
  void tearDown() {
    exampleRedisRepository.deleteAll();
  }

  @Test
  void save() {
    String id = UUID.randomUUID().toString();
    ExampleRedisEntity example =
        ExampleRedisEntity.builder().id(id).exampleField("example").build();

    exampleRedisRepository.save(example);

    Optional<ExampleRedisEntity> found = exampleRedisRepository.findById(id);
    assertThat(found)
        .isPresent()
        .hasValueSatisfying(
            e -> {
              assertThat(e.getId()).isEqualTo(id);
              assertThat(e.getExampleField()).isEqualTo("example");
            });
  }
}
