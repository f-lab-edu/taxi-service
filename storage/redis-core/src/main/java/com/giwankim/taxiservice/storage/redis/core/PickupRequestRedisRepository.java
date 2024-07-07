package com.giwankim.taxiservice.storage.redis.core;

import org.springframework.data.repository.CrudRepository;

public interface PickupRequestRedisRepository
    extends CrudRepository<PickupRequestRedisEntity, String> {}
