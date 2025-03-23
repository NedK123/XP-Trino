package org.example.analyticsservice.persistence;

import java.util.Map;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
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
    String query = QueryUtilities.fetchQuery("general_stats_query.sql");
    Map<String, Integer> map =
        jdbcTemplate
            .query(
                query,
                (rs, rowNum) ->
                    GeneralStatsRow.builder()
                        .recordType(rs.getString("recordType"))
                        .rowCount(rs.getInt("rowCount"))
                        .build())
            .stream()
            .collect(
                Collectors.toMap(GeneralStatsRow::getRecordType, GeneralStatsRow::getRowCount));
    return GeneralStatsReport.builder()
        .numberOfReservations(map.get("reservations"))
        .totalNbOfCustomers(map.get("customers"))
        .build();
  }

  @Builder
  @Data
  private static class GeneralStatsRow {
    private String recordType;
    private int rowCount;
  }
}
