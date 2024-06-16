package com.giwankim.taxiservice.core.domain.domain;

import java.math.RoundingMode;
import java.util.Collection;
import java.util.function.Function;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

@Getter
@ToString
@EqualsAndHashCode
public class KRWMoney {
  public static final CurrencyUnit KRW = CurrencyUnit.of("KRW");

  public static final KRWMoney ZERO = KRWMoney.wons(0);

  private final Money amount;

  public static KRWMoney wons(long amount) {
    return new KRWMoney(Money.of(KRW, amount, RoundingMode.HALF_DOWN));
  }

  public static KRWMoney wons(double amount) {
    return new KRWMoney(Money.of(KRW, amount, RoundingMode.HALF_DOWN));
  }

  public static <T> KRWMoney sum(Collection<T> bags, Function<T, KRWMoney> monetary) {
    return bags.stream().map(monetary).reduce(KRWMoney.ZERO, KRWMoney::plus);
  }

  private KRWMoney(Money amount) {
    this.amount = amount;
  }

  public KRWMoney plus(KRWMoney amount) {
    return new KRWMoney(this.amount.plus(amount.amount));
  }

  public KRWMoney minus(KRWMoney amount) {
    return new KRWMoney(this.amount.minus(amount.amount));
  }

  public KRWMoney times(double percent) {
    return new KRWMoney(this.amount.multipliedBy(percent, RoundingMode.HALF_DOWN));
  }

  public KRWMoney divide(double divisor) {
    return new KRWMoney(amount.dividedBy(divisor, RoundingMode.HALF_DOWN));
  }

  public boolean isLessThan(KRWMoney other) {
    return amount.isLessThan(other.amount);
  }

  public boolean isGreaterThanOrEqual(KRWMoney other) {
    return amount.compareTo(other.amount) >= 0;
  }

  public long longValue() {
    return amount.getAmount().longValue();
  }

  public double doubleValue() {
    return amount.getAmount().doubleValue();
  }
}
