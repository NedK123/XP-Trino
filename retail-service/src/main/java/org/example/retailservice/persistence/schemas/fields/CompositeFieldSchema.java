package org.example.retailservice.persistence.schemas.fields;

public interface CompositeFieldSchema extends FieldSchema {
  default boolean includeFieldName() {
    return true;
  }
}
