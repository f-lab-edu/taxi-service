package com.giwankim.taxiservice.client.fare;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import org.springframework.util.ResourceUtils;

public class FileUtils {
  private FileUtils() {}

  public static String read(String filePath) {
    try {
      File file = ResourceUtils.getFile(filePath);
      return new String(Files.readAllBytes(file.toPath()));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
