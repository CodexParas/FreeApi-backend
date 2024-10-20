package com.paras.FreeAPIs.servicesImpl.kitchenServiceImpl;

import com.fasterxml.jackson.databind.JsonNode;
import com.paras.FreeAPIs.DTO.ResponseDTO;
import com.paras.FreeAPIs.services.kitchenServices.StatusCodeService;
import com.paras.FreeAPIs.utils.JsonSupplier;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StatusCodeServiceImpl implements StatusCodeService {

    private final JsonSupplier jsonSupplier;
    private JsonNode statusCodes;

    public ResponseDTO getAllStatusCodes () {
        if (statusCodes == null) {
            statusCodes = jsonSupplier.getJson("status-codes");
        }
        return ResponseDTO.success("Status codes fetched successfully", statusCodes);
    }

    public ResponseDTO getStatusCode (String code) {
        if (statusCodes == null) {
            statusCodes = jsonSupplier.getJson("status-codes");
        }
        Optional<JsonNode> statusCode = Optional.ofNullable(statusCodes.get(code));
        if (statusCode.isPresent()) {
            return ResponseDTO.success("Status code fetched successfully", statusCode.get());
        }
        return ResponseDTO.error("Status code not found", null);
    }
}
