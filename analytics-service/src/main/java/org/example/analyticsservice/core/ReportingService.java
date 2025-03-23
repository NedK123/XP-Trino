package org.example.analyticsservice.core;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ReportingService {
  private final GeneralStatsService generalStatsService;

  public GeneralStatsReport generate() {
    return generalStatsService.generate();
  }
}
