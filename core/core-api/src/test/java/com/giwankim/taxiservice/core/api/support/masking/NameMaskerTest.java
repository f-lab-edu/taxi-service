package com.giwankim.taxiservice.core.api.support.masking;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class NameMaskerTest {
  NameMasker masker = new NameMasker();

  @Test
  void should_mask_two_letter_korean_name() {
    assertThat(masker.mask("허준")).isEqualTo("허*");
  }

  @Test
  void should_mask_three_letter_korean_name() {
    assertThat(masker.mask("강감찬")).isEqualTo("강*찬");
    assertThat(masker.mask("김유신")).isEqualTo("김*신");
    assertThat(masker.mask("이순신")).isEqualTo("이*신");
  }

  @Test
  void should_mask_four_letter_korean_name() {
    assertThat(masker.mask("남궁건우")).isEqualTo("남**우");
    assertThat(masker.mask("독고영재")).isEqualTo("독**재");
  }

  @Test
  void should_mask_an_English_name_with_less_than_6_characters() {
    assertThat(masker.mask("Ty")).isEqualTo("Ty");
    assertThat(masker.mask("Sam")).isEqualTo("S*m");
    assertThat(masker.mask("Jane")).isEqualTo("J**e");
    assertThat(masker.mask("Susan")).isEqualTo("S***n");
  }

  @Test
  void should_properly_mask_an_English_name_with_6_or_more_characters() {
    assertThat(masker.mask("David Beckham")).isEqualTo("Da*** *****am");
    assertThat(masker.mask("Luke Skywalker")).isEqualTo("Lu** *******er");
  }
}
