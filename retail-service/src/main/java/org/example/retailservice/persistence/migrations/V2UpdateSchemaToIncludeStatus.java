package org.example.retailservice.persistence.migrations;

import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import io.mongock.api.annotations.ChangeUnit;
import io.mongock.api.annotations.Execution;
import io.mongock.api.annotations.RollbackExecution;
import lombok.AllArgsConstructor;
import org.bson.Document;
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
        .updateOne(
            Filters.eq("table", "retail_records"), // Query to find the document
            Updates.pull(
                "fields", new Document("name", "status")) // Use $pull to remove the "status" field
            );
  }
}
