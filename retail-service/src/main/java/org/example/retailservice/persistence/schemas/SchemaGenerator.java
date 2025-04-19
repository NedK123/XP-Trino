package org.example.retailservice.persistence.schemas;

public class SchemaGenerator {
  public static Schema generate(int version) {
    return switch (version) {
      case 1 -> new RetailRecordsV1Schema();
      case 2 -> new RetailRecordsV2Schema();
      default -> throw new IllegalStateException("Unsupported version: " + version);
    };
  }
}
