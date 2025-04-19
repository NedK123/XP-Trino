package org.example.retailservice.persistence.schemas.fields;

import static java.lang.String.*;

import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractCompositeFieldSchema implements CompositeFieldSchema {

  @Override
  public String encoded() {
    StringBuilder encoded = new StringBuilder();
    if (includeFieldName()) {
      encoded.append(format("\"%s\" ", getName()));
    }
    return encoded.append(format("row(%s)", encodeChildren())).toString();
  }

  protected String encodeChildren() {
    return getFields().stream().map(FieldSchema::encoded).collect(Collectors.joining(","));
  }

  protected abstract List<FieldSchema> getFields();
}
