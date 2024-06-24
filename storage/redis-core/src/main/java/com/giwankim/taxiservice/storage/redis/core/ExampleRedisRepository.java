package com.giwankim.taxiservice.storage.redis.core;

import org.springframework.data.repository.CrudRepository;

public interface ExampleRedisRepository extends CrudRepository<ExampleRedisEntity, String> {}
