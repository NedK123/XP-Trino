package org.example.retailservice.persistence.schemas;

import java.util.Arrays;
import java.util.List;
import org.bson.Document;
import org.example.retailservice.persistence.schemas.fields.AbstractCompositeFieldSchema;
import org.example.retailservice.persistence.schemas.fields.FieldSchema;
import org.example.retailservice.persistence.schemas.fields.SimpleFieldsFactory;

public class RetailRecordsV1Schema implements Schema {

  @Override
  public Document asDoc() {
    return new Document("table", "retail_records")
        .append(
            "fields",
            Arrays.asList(
                new GenericId().asDoc(),
                new CustomerId().asDoc(),
                new PurchaseDate().asDoc(),
                new ItemsArray().asDoc(),
                new TotalAmount().asDoc(),
                new ShippingAddress().asDoc(),
                new PaymentMethod().asDoc(),
                new DeliveryInfo().asDoc(),
                new OrderDetails().asDoc()));
  }

  public static class GenericId implements Schema {
    @Override
    public Document asDoc() {
      return new Document("name", "_id").append("type", "ObjectId").append("hidden", true);
    }
  }

  public static class CustomerId implements Schema {
    @Override
    public Document asDoc() {
      return new Document("name", "customer_id").append("type", "double").append("hidden", false);
    }
  }

  public static class PurchaseDate implements Schema {
    @Override
    public Document asDoc() {
      return new Document("name", "purchase_date")
          .append("type", "timestamp(3)")
          .append("hidden", false);
    }
  }

  public static class ItemsArray implements Schema {

    @Override
    public Document asDoc() {
      return new Document("name", "items")
          .append("type", "array(" + new Item().encoded() + ")")
          .append("hidden", false);
    }

    private static class Item extends AbstractCompositeFieldSchema implements FieldSchema {
      @Override
      public String getName() {
        return "item";
      }

      @Override
      public boolean includeFieldName() {
        return false;
      }

      @Override
      protected List<FieldSchema> getFields() {
        return List.of(
            SimpleFieldsFactory.generate("item_id", "varchar"),
            SimpleFieldsFactory.generate("item_name", "varchar"),
            SimpleFieldsFactory.generate("quantity", "double"),
            SimpleFieldsFactory.generate("price", "double"));
      }
    }
  }

  public static class TotalAmount implements Schema {
    @Override
    public Document asDoc() {
      return new Document("name", "total_amount").append("type", "double").append("hidden", false);
    }
  }

  public static class ShippingAddress implements Schema {
    @Override
    public Document asDoc() {
      return new Document("name", "shipping_address")
          .append("type", "varchar")
          .append("hidden", false);
    }
  }

  public static class PaymentMethod implements Schema {
    @Override
    public Document asDoc() {
      return new Document("name", "payment_method")
          .append("type", "varchar")
          .append("hidden", false);
    }
  }

  public static class DeliveryInfo extends AbstractCompositeFieldSchema implements Schema {
    @Override
    public Document asDoc() {
      return new Document("name", getName()).append("type", encoded()).append("hidden", false);
    }

    @Override
    public String getName() {
      return "delivery_info";
    }

    @Override
    public boolean includeFieldName() {
      return false;
    }

    @Override
    protected List<FieldSchema> getFields() {
      return List.of(
          SimpleFieldsFactory.generate("delivery_date", "timestamp(3)"),
          SimpleFieldsFactory.generate("tracking_number", "varchar"),
          SimpleFieldsFactory.generate("carrier", "varchar"));
    }
  }

  public static class OrderDetails extends AbstractCompositeFieldSchema implements Schema {
    @Override
    public Document asDoc() {
      return new Document("name", getName()).append("type", encoded()).append("hidden", false);
    }

    @Override
    public String getName() {
      return "order_details";
    }

    @Override
    public boolean includeFieldName() {
      return false;
    }

    @Override
    protected List<FieldSchema> getFields() {
      return List.of(
          new Discount(), new Tax(), SimpleFieldsFactory.generate("total_with_tax", "double"));
    }

    private static class Discount extends AbstractCompositeFieldSchema {
      @Override
      public String getName() {
        return "discount";
      }

      @Override
      protected List<FieldSchema> getFields() {
        return List.of(
            SimpleFieldsFactory.generate("amount", "double"),
            SimpleFieldsFactory.generate("description", "varchar"));
      }
    }

    private static class Tax extends AbstractCompositeFieldSchema {
      @Override
      public String getName() {
        return "tax";
      }

      @Override
      protected List<FieldSchema> getFields() {
        return List.of(
            SimpleFieldsFactory.generate("amount", "double"),
            SimpleFieldsFactory.generate("description", "varchar"));
      }
    }
  }
}
