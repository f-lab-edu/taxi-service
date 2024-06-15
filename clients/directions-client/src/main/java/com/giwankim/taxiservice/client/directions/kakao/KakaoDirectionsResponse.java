package com.giwankim.taxiservice.client.directions.kakao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.giwankim.taxiservice.core.domain.domain.Directions;
import com.giwankim.taxiservice.core.domain.domain.Location;
import java.util.List;

@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public record KakaoDirectionsResponse(List<Route> routes) {
  Directions toDirections() {
    Route route = routes.getFirst();
    Location origin = route.summary().origin().toLocation();
    Location destination = route.summary().destination().toLocation();
    return new Directions(
        origin, destination, route.summary().distance(), route.summary().duration());
  }

  @JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
  @JsonIgnoreProperties(ignoreUnknown = true)
  record Route(Summary summary, List<Section> sections) {

    @JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
    @JsonIgnoreProperties(ignoreUnknown = true)
    record Summary(Origin origin, Destination destination, int distance, int duration) {
      record Origin(String name, double x, double y) {
        Location toLocation() {
          return new Location(name(), y(), x());
        }
      }

      record Destination(String name, double x, double y) {
        Location toLocation() {
          return new Location(name(), y(), x());
        }
      }
    }

    @JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
    @JsonIgnoreProperties(ignoreUnknown = true)
    record Section(int distance, int duration, List<Road> roads) {

      @JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
      @JsonIgnoreProperties(ignoreUnknown = true)
      record Road(String name, int distance, int duration) {}
    }
  }
}
