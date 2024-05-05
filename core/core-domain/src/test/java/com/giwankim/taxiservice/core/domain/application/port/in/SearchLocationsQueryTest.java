package com.giwankim.taxiservice.core.domain.application.port.in;

import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class SearchLocationsQueryTest {

  @Test
  @DisplayName("정상적으로 생성된다.")
  void validationOk() {
    SearchLocationsQuery query = new SearchLocationsQuery("강남역", 1, 10);
    assertThat(query.getKeyword()).isEqualTo("강남역");
    assertThat(query.getPage()).isEqualTo(1);
    assertThat(query.getSize()).isEqualTo(10);
  }

  @Test
  @DisplayName("쿼리 키워드가 null 이면 예외를 던진다.")
  void keywordValidationFails() {
    assertThatExceptionOfType(ConstraintViolationException.class)
      .isThrownBy(() ->
        new SearchLocationsQuery(null, 0, 10));
  }

  @Test
  @DisplayName("페이지나 사이즈가 null일 경우 디폴트로 세팅한다.")
  void shouldSetDefaultPageNumber() {
    assertThat(new SearchLocationsQuery("강남역", null, 10).getPage()).isEqualTo(1);
    assertThat(new SearchLocationsQuery("강남역", 1, null).getSize()).isEqualTo(10);
  }

  @Test
  @DisplayName("범위 밖의 값일 경우 예외를 던진다.")
  void outOfRangeValidationFails() {
    assertThatExceptionOfType(ConstraintViolationException.class)
      .isThrownBy(() ->
        new SearchLocationsQuery("강남역", 0, 1));
    assertThatExceptionOfType(ConstraintViolationException.class)
      .isThrownBy(() ->
        new SearchLocationsQuery("강남역", 46, 1));
    assertThatExceptionOfType(ConstraintViolationException.class)
      .isThrownBy(() ->
        new SearchLocationsQuery("강남역", 1, 31));
    assertThatExceptionOfType(ConstraintViolationException.class)
      .isThrownBy(() ->
        new SearchLocationsQuery("강남역", 1, 0));
  }
}