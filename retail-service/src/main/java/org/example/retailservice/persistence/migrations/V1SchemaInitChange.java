package org.example.retailservice.persistence.migrations;

import com.mongodb.client.model.Filters;
import io.mongock.api.annotations.ChangeUnit;
import io.mongock.api.annotations.Execution;
import io.mongock.api.annotations.RollbackExecution;
import lombok.AllArgsConstructor;
import org.example.retailservice.persistence.schemas.SchemaGenerator;
import org.springframework.data.mongodb.core.MongoTemplate;

@AllArgsConstructor
@ChangeUnit(id = "SchemaInitChange", order = "001", author = "nkahwaji")
public class V1SchemaInitChange {
  private final MongoTemplate mongoTemplate;

  @Execution
  public void changeSet() {
    mongoTemplate.createCollection("_schema");
    mongoTemplate.getCollection("_schema").insertOne(SchemaGenerator.generate().asDoc());
  }

  @RollbackExecution
  public void rollback() {
    mongoTemplate.getCollection("_schema").deleteOne(Filters.eq("table", "retail_records"));
  }
}
