package org.example.retailservice.persistence.schemas.fields;

public class SimpleFieldsFactory {
  public static FieldSchema generate(String fieldName, String fieldType) {
    return new FieldSchema() {
      @Override
      public String getName() {
        return fieldName;
      }

      @Override
      public String encoded() {
        return "\"" + fieldName + "\" " + fieldType;
      }
    };
  }
}
