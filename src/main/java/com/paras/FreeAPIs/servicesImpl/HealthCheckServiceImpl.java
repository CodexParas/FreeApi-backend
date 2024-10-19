package com.paras.FreeAPIs.servicesImpl;

import com.paras.FreeAPIs.DTO.ResponseDTO;
import com.paras.FreeAPIs.services.HealthCheckService;
import org.springframework.stereotype.Service;

@Service
public class HealthCheckServiceImpl implements HealthCheckService {
    public ResponseDTO healthCheck () {
        return ResponseDTO.success("Service is up and running", null);
    }
}
