package com.paras.FreeAPIs.servicesImpl.kitchenServiceImpl;

import com.fasterxml.jackson.databind.JsonNode;
import com.paras.FreeAPIs.DTO.ResponseDTO;
import com.paras.FreeAPIs.services.kitchenServices.CookieService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class CookieServiceImpl implements CookieService {
    public ResponseDTO getCookie (HttpServletRequest request) {
        List<Cookie> cookies = List.of(request.getCookies());
        return ResponseDTO.success("Cookies fetched successfully", cookies);
    }

    public ResponseDTO setCookie (JsonNode requestBody, HttpServletResponse response, HttpServletRequest request) {
        Iterator<String> fieldNames = requestBody.fieldNames();
        while (fieldNames.hasNext()) {
            String fieldName = fieldNames.next();
            String fieldValue = requestBody.get(fieldName).asText();
            Cookie cookie = new Cookie(fieldName, fieldValue);
            response.addCookie(cookie);
        }
        List<Cookie> cookies = List.of(request.getCookies());
        return ResponseDTO.success("Cookies set successfully", cookies);
    }

    public ResponseDTO removeCookie (HttpServletRequest request, HttpServletResponse response, String cookieKey) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(cookieKey)) {
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                    return ResponseDTO.success("Cookie removed successfully", null);
                }
            }
        }
        return ResponseDTO.error("Cookie not found", null);
    }
}
