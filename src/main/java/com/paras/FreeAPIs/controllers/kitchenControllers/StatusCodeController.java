package com.paras.FreeAPIs.controllers.kitchenControllers;

import com.paras.FreeAPIs.DTO.ResponseDTO;
import com.paras.FreeAPIs.services.kitchenServices.StatusCodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status-codes")
@RequiredArgsConstructor
public class StatusCodeController extends KitchenController {

    private final StatusCodeService statusCodeService;

    @GetMapping("/")
    public ResponseEntity<ResponseDTO> getAllStatusCodes () {
        return ResponseEntity.ok(statusCodeService.getAllStatusCodes());
    }

    @GetMapping("/{code}")
    public ResponseEntity<ResponseDTO> getStatusCode (@PathVariable String code) {
        return ResponseEntity.ok(statusCodeService.getStatusCode(code));
    }
}
