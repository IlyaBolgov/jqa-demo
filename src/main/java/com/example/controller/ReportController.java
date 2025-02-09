package com.example.controller;

import com.example.service.ReportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reports")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    /**
     * Endpoint to generate and return a report.
     */
    @GetMapping
    public ResponseEntity<String> getReport() {
        String report = reportService.makeReport();
        return ResponseEntity.ok(report);
    }

    /**
     * Endpoint to save the report.
     */
    @PostMapping("/save")
    public ResponseEntity<String> saveReport() {
        try {
            reportService.saveReport();
            return ResponseEntity.ok("Report saved successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
