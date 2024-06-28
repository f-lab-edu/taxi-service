package com.giwankim.taxiservice.core.api.support.masking;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import java.io.IOException;
import org.springframework.boot.jackson.JsonComponent;

@JsonComponent
public class MaskingSerializer extends JsonSerializer<String> implements ContextualSerializer {
  private MaskingType maskingType;

  public MaskingSerializer() {}

  public MaskingSerializer(MaskingType maskingType) {
    this.maskingType = maskingType;
  }

  @Override
  public void serialize(String value, JsonGenerator generator, SerializerProvider provider)
      throws IOException {
    if (maskingType == null) {
      generator.writeString(value);
      return;
    }
    generator.writeString(maskingType.getMasker().mask(value));
  }

  @Override
  public JsonSerializer<?> createContextual(SerializerProvider provider, BeanProperty property)
      throws JsonMappingException {
    if (property == null) {
      return this;
    }
    Masked maskedAnnotation = property.getAnnotation(Masked.class);
    if (maskedAnnotation != null) {
      return new MaskingSerializer(maskedAnnotation.value());
    }
    return this;
  }
}
