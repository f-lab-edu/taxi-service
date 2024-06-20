package com.giwankim.taxiservice.core.domain.domain;

import static com.giwankim.taxiservice.domain.Fixtures.aDirections;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TaxiTypeTest {

  @ParameterizedTest(name = "택시 유형: {0}, 기본 요금: {1}, 예상 요금: {3}")
  @MethodSource("provideArgumentsForCalculateTotalFare")
  @DisplayName("calculateTotalFare 메서드 테스트")
  void calculateTotalFare(
      TaxiType taxiType, KRWMoney baseFare, Directions directions, KRWMoney expectedTotalFare) {
    assertThat(taxiType.calculateTotalFare(baseFare, directions)).isEqualTo(expectedTotalFare);
  }

  private static Stream<Arguments> provideArgumentsForCalculateTotalFare() {
    return Stream.of(
        Arguments.of(
            TaxiType.REGULAR, KRWMoney.wons(10_000), aDirections().build(), KRWMoney.wons(10_000)),
        Arguments.of(
            TaxiType.DELUXE, KRWMoney.wons(10_000), aDirections().build(), KRWMoney.wons(15_000)),
        Arguments.of(
            TaxiType.JUMBO, KRWMoney.wons(10_000), aDirections().build(), KRWMoney.wons(20_000)));
  }
}
