package com.paras.FreeAPIs.services.kitchen;

import com.fasterxml.jackson.databind.JsonNode;
import com.paras.FreeAPIs.DTO.ResponseDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface CookieService {
    ResponseDTO getCookie (HttpServletRequest request);

    ResponseDTO setCookie (JsonNode requestBody, HttpServletResponse response, HttpServletRequest request);

    ResponseDTO removeCookie (HttpServletRequest request, HttpServletResponse response, String cookieKey);
}
