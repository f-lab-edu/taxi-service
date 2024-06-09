package com.giwankim.taxiservice.client.fare;

import org.springframework.util.ResourceUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileUtils {
  private FileUtils() {}

  public static String read(String filePath) {
    try {
      File file = ResourceUtils.getFile(filePath);
      StringBuilder stringBuilder = new StringBuilder();
      try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
        String line;
        while ((line = reader.readLine()) != null) {
          stringBuilder.append(line).append("\n");
        }
      }
      return stringBuilder.toString();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
