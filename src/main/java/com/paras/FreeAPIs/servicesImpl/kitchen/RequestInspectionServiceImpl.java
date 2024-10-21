package com.paras.FreeAPIs.servicesImpl.kitchen;

import com.paras.FreeAPIs.DTO.ResponseDTO;
import com.paras.FreeAPIs.services.kitchen.RequestInspectionService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RequestInspectionServiceImpl implements RequestInspectionService {
    private static HttpHeaders getAllHeaders (HttpServletRequest req) {
        HttpHeaders headers = new HttpHeaders();
        req.getHeaderNames().asIterator().forEachRemaining(
                headerName -> headers.add(headerName, req.getHeader(headerName))
                                                          );
        return headers;
    }

    public ResponseDTO getHeaders (HttpServletRequest request) {
        return ResponseDTO.success("Fetched all headers", getAllHeaders(request));
    }

    public ResponseDTO getIp (HttpServletRequest request) {
        Map<String, String> ips = new HashMap<>();
        ips.put("remoteAddr", request.getRemoteAddr());
        ips.put("remoteHost", request.getRemoteHost());
        ips.put("remotePort", String.valueOf(request.getRemotePort()));
        ips.put("remoteUser", request.getRemoteUser());
        ips.put("localAddr", request.getLocalAddr());
        ips.put("localName", request.getLocalName());
        ips.put("localPort", String.valueOf(request.getLocalPort()));
        return ResponseDTO.success("Fetched IP", ips);
    }

    public ResponseDTO getUserAgent (HttpServletRequest request) {
        return ResponseDTO.success("Fetched User-Agent", request.getHeader("User-Agent"));
    }

    public ResponseDTO getPathVariables (String pathVariable) {
        return ResponseDTO.success("Fetched path variable", pathVariable);
    }

    public ResponseDTO getQueryParameter (Map<String, String> queryParameters) {
        return ResponseDTO.success("Fetched query parameters", queryParameters);
    }
}
