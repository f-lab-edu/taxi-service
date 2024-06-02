package com.giwankim.taxiservice.core.domain.application.port.in;

public record SearchLocationsQuery(String keyword, int page, int size) {}
