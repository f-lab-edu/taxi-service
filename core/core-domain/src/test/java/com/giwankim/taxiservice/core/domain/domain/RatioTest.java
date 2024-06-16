package com.giwankim.taxiservice.core.domain.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RatioTest {

  @Test
  void percent() {
    Ratio tenPercent = Ratio.valueOf(0.1);
    KRWMoney tenThousandWon = KRWMoney.wons(10000);
    assertThat(tenPercent.of(tenThousandWon)).isEqualTo(KRWMoney.wons(1000));
  }
}
