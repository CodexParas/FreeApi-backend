package com.paras.FreeAPIs.controllers.kitchenControllers;

import com.paras.FreeAPIs.DTO.ResponseDTO;
import com.paras.FreeAPIs.services.kitchenServices.RequestInspectionService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/request")
public class RequestInspectionController extends KitchenController {

    private final RequestInspectionService requestInspectionService;

    @GetMapping("/headers")
    public ResponseEntity<ResponseDTO> getHeaders (HttpServletRequest request) {
        return ResponseEntity.ok(requestInspectionService.getHeaders(request));
    }

    @GetMapping("/ip")
    public ResponseEntity<ResponseDTO> getIp (HttpServletRequest request) {
        return ResponseEntity.ok(requestInspectionService.getIp(request));
    }

    @GetMapping("/user-agent")
    public ResponseEntity<ResponseDTO> getUserAgent (HttpServletRequest request) {
        return ResponseEntity.ok(requestInspectionService.getUserAgent(request));
    }

    @GetMapping("/path-variables/{pathVariable}")
    public ResponseEntity<ResponseDTO> getPathVariables (@PathVariable String pathVariable) {
        return ResponseEntity.ok(requestInspectionService.getPathVariables(pathVariable));
    }

    @GetMapping("/query-parameter")
    public ResponseEntity<ResponseDTO> getQueryParameter (@RequestParam Map<String, String> queryParameters) {
        return ResponseEntity.ok(requestInspectionService.getQueryParameter(queryParameters));
    }
}
