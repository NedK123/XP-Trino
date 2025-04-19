package org.example.retailservice.persistence.migrations;

import com.mongodb.client.model.Filters;
import io.mongock.api.annotations.ChangeUnit;
import io.mongock.api.annotations.Execution;
import io.mongock.api.annotations.RollbackExecution;
import lombok.AllArgsConstructor;
import org.example.retailservice.persistence.schemas.SchemaGenerator;
import org.springframework.data.mongodb.core.MongoTemplate;

@AllArgsConstructor
@ChangeUnit(id = "UpdateSchemaToIncludeStatus", order = "002", author = "nkahwaji")
public class V2UpdateSchemaToIncludeStatus {
  private final MongoTemplate mongoTemplate;

  @Execution
  public void changeSet() {
    mongoTemplate
        .getCollection("_schema")
        .replaceOne(Filters.eq("table", "retail_records"), SchemaGenerator.generate(2).asDoc());
  }

  @RollbackExecution
  public void rollback() {
    mongoTemplate
        .getCollection("_schema")
        .replaceOne(Filters.eq("table", "retail_records"), SchemaGenerator.generate(1).asDoc());
  }
}
