package com.giwankim.taxiservice.client.fare;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Collectors;
import org.springframework.util.ResourceUtils;

public class FileUtils {
  private FileUtils() {}

  public static String read(String filePath) {
    try {
      File file = ResourceUtils.getFile(filePath);
      try (BufferedReader reader = Files.newBufferedReader(file.toPath())) {
        return reader.lines().collect(Collectors.joining(System.lineSeparator()));
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
