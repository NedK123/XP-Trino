package org.example.analyticsservice.core;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GeneralStatsReport {
  private int numberOfReservations;
  private int totalNbOfCustomers;
}
