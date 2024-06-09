package com.giwankim.taxiservice.core.domain.domain;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Objects;
import java.util.function.Function;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Money {
  public static final Money ZERO = Money.wons(0);

  private final BigDecimal amount;

  public static Money wons(long amount) {
    return new Money(BigDecimal.valueOf(amount));
  }

  public static Money wons(double amount) {
    return new Money(BigDecimal.valueOf(amount));
  }

  public static <T> Money sum(Collection<T> bags, Function<T, Money> monetary) {
    return bags.stream().map(monetary).reduce(Money.ZERO, Money::plus);
  }

  Money(BigDecimal amount) {
    this.amount = amount;
  }

  public Money plus(Money amount) {
    return new Money(this.amount.add(amount.amount));
  }

  public Money minus(Money amount) {
    return new Money(this.amount.subtract(amount.amount));
  }

  public Money times(double percent) {
    return new Money(this.amount.multiply(BigDecimal.valueOf(percent)));
  }

  public Money divide(double divisor) {
    return new Money(amount.divide(BigDecimal.valueOf(divisor)));
  }

  public boolean isLessThan(Money other) {
    return amount.compareTo(other.amount) < 0;
  }

  public boolean isGreaterThanOrEqual(Money other) {
    return amount.compareTo(other.amount) >= 0;
  }

  public long longValue() {
    return amount.longValue();
  }

  public double doubleValue() {
    return amount.doubleValue();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Money money)) return false;
    return Objects.equals(amount.doubleValue(), money.amount.doubleValue());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(amount);
  }
}
