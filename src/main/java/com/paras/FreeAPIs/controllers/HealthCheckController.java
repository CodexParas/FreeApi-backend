package com.paras.FreeAPIs.controllers;


import com.paras.FreeAPIs.DTO.ResponseDTO;
import com.paras.FreeAPIs.services.HealthCheckService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "Health Check", description = "Health Check API")
public class HealthCheckController {

    private final HealthCheckService healthCheckService;

    @GetMapping("/health")
    public ResponseEntity<ResponseDTO> healthCheck () {
        return ResponseEntity.ok(healthCheckService.healthCheck());
    }
}
