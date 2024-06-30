package com.giwankim.taxiservice.core.api.support.masking;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class PhoneMaskerTest {
  PhoneMasker masker = new PhoneMasker();

  @Test
  void should_properly_mask_a_phone_number_separated_by_hyphens() {
    SoftAssertions.assertSoftly(
        softly -> {
          softly.assertThat(masker.mask("010-1234-5678")).isEqualTo("010-****-5678");
          softly.assertThat(masker.mask("02-123-4567")).isEqualTo("02-***-4567");
          softly.assertThat(masker.mask("02-1234-5678")).isEqualTo("02-****-5678");
          softly.assertThat(masker.mask("031-222-2222")).isEqualTo("031-***-2222");
        });
  }

  @Test
  void should_mask_a_phone_number_not_separated_by_hyphens() {
    SoftAssertions.assertSoftly(
        softly -> {
          softly.assertThat(masker.mask("01012345678")).isEqualTo("010****5678");
          softly.assertThat(masker.mask("021234567")).isEqualTo("02***4567");
          softly.assertThat(masker.mask("0212345678")).isEqualTo("02****5678");
          softly.assertThat(masker.mask("0312222222")).isEqualTo("031***2222");
        });
  }
}
