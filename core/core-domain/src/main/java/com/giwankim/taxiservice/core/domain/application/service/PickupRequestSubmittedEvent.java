package com.giwankim.taxiservice.core.domain.application.service;

import com.giwankim.taxiservice.core.domain.domain.PickupRequest;

record PickupRequestSubmittedEvent(PickupRequest pickupRequest) {}
