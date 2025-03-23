package org.example.analyticsservice.api;

import lombok.AllArgsConstructor;
import org.example.analyticsservice.core.GeneralStatsReport;
import org.example.analyticsservice.core.ReportingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/report")
public class ReportsController {
  private final ReportingService reportingService;

  @GetMapping("/")
  public ResponseEntity<GeneralStatsReport> generateReport() {
    return ResponseEntity.ok(reportingService.generate());
  }
}
