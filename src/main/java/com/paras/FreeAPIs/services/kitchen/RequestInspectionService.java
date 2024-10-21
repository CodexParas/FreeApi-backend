package com.paras.FreeAPIs.services.kitchen;

import com.paras.FreeAPIs.DTO.ResponseDTO;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Map;

public interface RequestInspectionService {
    ResponseDTO getHeaders (HttpServletRequest request);

    ResponseDTO getIp (HttpServletRequest request);

    ResponseDTO getUserAgent (HttpServletRequest request);

    ResponseDTO getPathVariables (String pathVariable);

    ResponseDTO getQueryParameter (Map<String, String> queryParameters);
}
