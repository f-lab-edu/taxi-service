package com.giwankim.taxiservice.client.directions;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import org.springframework.util.ResourceUtils;

public class FileUtils {
  private FileUtils() {}

  public static String read(String filePath) {
    try {
      File file = ResourceUtils.getFile(filePath);
      try (BufferedReader reader = Files.newBufferedReader(file.toPath())) {
        StringBuilder stringBuilder = new StringBuilder();
        reader.lines().forEach(line -> stringBuilder.append(line).append("\n"));
        return stringBuilder.toString();
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
