package com.giwankim.taxiservice.client.location;

public record LocationRequest(String query, Integer page, Integer size) {
}
