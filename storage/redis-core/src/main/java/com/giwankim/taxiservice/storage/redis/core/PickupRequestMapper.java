package com.giwankim.taxiservice.storage.redis.core;

import com.giwankim.taxiservice.core.domain.domain.Location;
import com.giwankim.taxiservice.core.domain.domain.Passenger;
import com.giwankim.taxiservice.core.domain.domain.PickupRequest;
import org.springframework.stereotype.Component;

@Component
public class PickupRequestMapper {
  public PickupRequestRedisEntity mapToEntity(PickupRequest pickupRequest, Long ttlInSeconds) {
    return new PickupRequestRedisEntity(
        pickupRequest.getId() == null ? null : pickupRequest.getId().value(),
        pickupRequest.getStatus(),
        mapToPassengerEntity(pickupRequest.getPassenger()),
        new LocationRedisEntity(pickupRequest.getPickup()),
        new LocationRedisEntity(pickupRequest.getDropoff()),
        pickupRequest.getTaxiType(),
        ttlInSeconds);
  }

  private PassengerRedisEntity mapToPassengerEntity(Passenger passenger) {
    return new PassengerRedisEntity(
        passenger.getId().value(),
        passenger.getUsername(),
        passenger.getPhoneNumber(),
        passenger.getPhoneNumber());
  }

  public PickupRequest mapToDomain(PickupRequestRedisEntity pickupRequestRedisEntity) {
    return new PickupRequest(
        new PickupRequest.RequestId(pickupRequestRedisEntity.getId()),
        pickupRequestRedisEntity.getStatus(),
        mapToPassenger(pickupRequestRedisEntity.getPassenger()),
        mapToLocation(pickupRequestRedisEntity.getPickup()),
        mapToLocation(pickupRequestRedisEntity.getDropoff()),
        pickupRequestRedisEntity.getTaxiType());
  }

  private Passenger mapToPassenger(PassengerRedisEntity passengerRedisEntity) {
    return new Passenger(
        new Passenger.PassengerId(passengerRedisEntity.getId()),
        passengerRedisEntity.getUsername(),
        passengerRedisEntity.getPassword(),
        passengerRedisEntity.getPhoneNumber());
  }

  private Location mapToLocation(LocationRedisEntity locationEntity) {
    return new Location(
        locationEntity.getName(),
        locationEntity.getPoint().getY(),
        locationEntity.getPoint().getX());
  }
}
