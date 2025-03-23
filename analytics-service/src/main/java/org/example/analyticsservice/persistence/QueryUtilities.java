package org.example.analyticsservice.persistence;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class QueryUtilities {
  public static String fetchQuery(String queryFileName) {
    try {
      return new String(
          Files.readAllBytes(
              Paths.get("analytics-service/src/main/resources/queries/" + queryFileName)));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
