package org.example.retailservice;

import io.mongock.runner.springboot.EnableMongock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableMongock
@SpringBootApplication
public class RetailServiceApplication {
  public static void main(String[] args) {
    SpringApplication.run(RetailServiceApplication.class, args);
  }
}
