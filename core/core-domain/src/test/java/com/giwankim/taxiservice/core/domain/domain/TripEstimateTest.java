package com.giwankim.taxiservice.core.domain.domain;

import static com.giwankim.taxiservice.domain.Fixtures.aDirections;
import static org.assertj.core.api.Assertions.assertThat;

import com.giwankim.taxiservice.core.domain.domain.surcharge.AmountSurchargePolicy;
import com.giwankim.taxiservice.core.domain.domain.surcharge.NoneSurchargePolicy;
import com.giwankim.taxiservice.core.enums.TaxiType;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TripEstimateTest {

  @ParameterizedTest(name = "{0}")
  @MethodSource("provideArgumentsForCreate")
  @DisplayName("create 메서드 테스트")
  void create(TaxiType taxiType, Class<?> expectedSurchargePolicyClass) {
    Money baseFare = Money.wons(10_000);
    assertThat(TripEstimate.create(taxiType, baseFare).getSurchargePolicy())
        .isInstanceOf(expectedSurchargePolicyClass);
  }

  private static Stream<Arguments> provideArgumentsForCreate() {
    return Stream.of(
        Arguments.of(TaxiType.REGULAR, NoneSurchargePolicy.class),
        Arguments.of(TaxiType.DELUXE, AmountSurchargePolicy.class),
        Arguments.of(TaxiType.JUMBO, AmountSurchargePolicy.class));
  }

  @ParameterizedTest(name = "택시 유형: {0}, 기본 요금: {1}, 예상 요금: {3}")
  @MethodSource("provideArgumentsForCalculateTotalFare")
  @DisplayName("calculateTotalFare 메서드 테스트")
  void calculateTotalFare(
      TaxiType taxiType, Money baseFare, Directions directions, Money expectedTotalFare) {
    TripEstimate tripEstimate = TripEstimate.create(taxiType, baseFare);
    Money actualTotalFare = tripEstimate.calculateTotalFare(directions);
    assertThat(actualTotalFare).isEqualTo(expectedTotalFare);
  }

  private static Stream<Arguments> provideArgumentsForCalculateTotalFare() {
    return Stream.of(
        Arguments.of(
            TaxiType.REGULAR, Money.wons(10_000), aDirections().build(), Money.wons(10_000)),
        Arguments.of(
            TaxiType.DELUXE, Money.wons(10_000), aDirections().build(), Money.wons(15_000)),
        Arguments.of(
            TaxiType.JUMBO, Money.wons(10_000), aDirections().build(), Money.wons(20_000)));
  }
}
