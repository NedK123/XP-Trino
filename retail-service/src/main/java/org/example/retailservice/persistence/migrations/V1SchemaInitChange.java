package org.example.retailservice.persistence.migrations;

import com.mongodb.client.model.Filters;
import io.mongock.api.annotations.ChangeUnit;
import io.mongock.api.annotations.Execution;
import io.mongock.api.annotations.RollbackExecution;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;

@AllArgsConstructor
@ChangeUnit(id = "SchemaInitChange", order = "001", author = "nkahwaji")
public class V1SchemaInitChange {
  private final MongoTemplate mongoTemplate;

  @Execution
  public void changeSet() {
    mongoTemplate.createCollection("_schema");
    Document schemaDocument =
        new Document("table", "retail_records")
            .append(
                "fields",
                Arrays.asList(
                    new Document("name", "_id").append("type", "ObjectId").append("hidden", true),
                    new Document("name", "customer_id")
                        .append("type", "double")
                        .append("hidden", false),
                    new Document("name", "purchase_date")
                        .append("type", "timestamp(3)")
                        .append("hidden", false),
                    new Document("name", "items")
                        .append(
                            "type",
                            "array(row(\"item_id\" varchar,\"item_name\" varchar,\"quantity\" double,\"price\" double))")
                        .append("hidden", false),
                    new Document("name", "total_amount")
                        .append("type", "double")
                        .append("hidden", false),
                    new Document("name", "shipping_address")
                        .append("type", "varchar")
                        .append("hidden", false),
                    new Document("name", "payment_method")
                        .append("type", "varchar")
                        .append("hidden", false),
                    new Document("name", "delivery_info")
                        .append(
                            "type",
                            "row(\"delivery_date\" timestamp(3),\"tracking_number\" varchar,\"carrier\" varchar)")
                        .append("hidden", false),
                    new Document("name", "order_details")
                        .append(
                            "type",
                            "row(\"discount\" row(\"amount\" double,\"description\" varchar),\"tax\" row(\"amount\" double,\"description\" varchar),\"total_with_tax\" double)")
                        .append("hidden", false)));

    mongoTemplate.getCollection("_schema").insertOne(schemaDocument);
  }

  @RollbackExecution
  public void rollback() {
    mongoTemplate.getCollection("_schema").deleteOne(Filters.eq("table", "retail_records"));
  }
}
