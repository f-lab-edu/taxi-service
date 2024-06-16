package com.giwankim.taxiservice.core.domain.domain.surcharge;

import static com.giwankim.taxiservice.domain.Fixtures.aDirections;
import static org.assertj.core.api.Assertions.assertThat;

import com.giwankim.taxiservice.core.domain.domain.KRWMoney;
import com.giwankim.taxiservice.core.domain.domain.SurchargePolicy;
import org.junit.jupiter.api.Test;

class AmountSurchargePolicyTest {
  @Test
  void calculateSurchargeAmount() {
    SurchargePolicy sut = new AmountSurchargePolicy(KRWMoney.wons(2000));
    KRWMoney actualAmount =
        sut.calculateSurchargeAmount(KRWMoney.wons(10_000), aDirections().build());
    assertThat(actualAmount).isEqualTo(KRWMoney.wons(2000));
  }
}
