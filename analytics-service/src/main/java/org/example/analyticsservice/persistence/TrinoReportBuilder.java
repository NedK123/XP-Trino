package org.example.analyticsservice.persistence;

import lombok.AllArgsConstructor;
import org.example.analyticsservice.core.GeneralStatsReport;
import org.example.analyticsservice.core.GeneralStatsService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class TrinoReportBuilder implements GeneralStatsService {
  private JdbcTemplate jdbcTemplate;

  @Override
  public GeneralStatsReport generate() {
    return null;
  }
}
