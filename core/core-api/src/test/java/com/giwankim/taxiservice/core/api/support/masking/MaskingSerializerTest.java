package com.giwankim.taxiservice.core.api.support.masking;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;

@JsonTest
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class MaskingSerializerTest {
  @Autowired JacksonTester<Person> jacksonTester;

  @Test
  @DisplayName("직렬화 시 이름을 마스킹한다.")
  void serialization_masks_names() throws IOException {
    Person person = new Person("홍길동", "010-1234-5678", "공개 정보");
    JsonContent<Person> json = jacksonTester.write(person);
    assertThat(json).extractingJsonPathStringValue("@.name").isEqualTo("홍*동");
  }

  @Test
  @DisplayName("직렬화 시 전화번호를 마스킹한다.")
  void serialization_masks_phone_numbers() throws IOException {
    Person person = new Person("홍길동", "010-1234-5678", "공개 정보");
    JsonContent<Person> json = jacksonTester.write(person);
    assertThat(json).extractingJsonPathStringValue("@.phoneNumber").isEqualTo("010-****-5678");
  }

  @Test
  @DisplayName("직렬화 시 마스킹 안 한다.")
  void serialization_does_not_mask() throws IOException {
    Person person = new Person("홍길동", "010-1234-5678", "공개 정보");
    JsonContent<Person> json = jacksonTester.write(person);
    assertThat(json).extractingJsonPathStringValue("@.publicField").isEqualTo("공개 정보");
  }

  private static class Person {
    @Masked(MaskingType.NAME)
    private String name;

    @Masked(MaskingType.PHONE_NUMBER)
    private String phoneNumber;

    private String publicField;

    public Person(String name, String phoneNumber, String publicField) {
      this.name = name;
      this.phoneNumber = phoneNumber;
      this.publicField = publicField;
    }

    public String getName() {
      return name;
    }

    public String getPhoneNumber() {
      return phoneNumber;
    }

    public String getPublicField() {
      return publicField;
    }
  }
}
