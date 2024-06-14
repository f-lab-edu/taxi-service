package com.giwankim.taxiservice.core.domain.domain.surcharge;

import static com.giwankim.taxiservice.domain.Fixtures.aDirections;
import static org.assertj.core.api.Assertions.assertThat;

import com.giwankim.taxiservice.core.domain.domain.Money;
import com.giwankim.taxiservice.core.domain.domain.SurchargePolicy;
import org.junit.jupiter.api.Test;

class AmountSurchargePolicyTest {
  @Test
  void calculateSurchargeAmount() {
    SurchargePolicy sut = new AmountSurchargePolicy(Money.wons(2000));
    Money actualAmount = sut.calculateSurchargeAmount(Money.wons(10_000), aDirections().build());
    assertThat(actualAmount).isEqualTo(Money.wons(2000));
  }
}
