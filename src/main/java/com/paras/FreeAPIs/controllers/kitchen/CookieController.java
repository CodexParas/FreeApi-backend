package com.paras.FreeAPIs.controllers.kitchen;

import com.fasterxml.jackson.databind.JsonNode;
import com.paras.FreeAPIs.DTO.ResponseDTO;
import com.paras.FreeAPIs.services.kitchen.CookieService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cookie")
@RequiredArgsConstructor
public class CookieController extends KitchenController {

    private final CookieService cookieService;


    @GetMapping("/get")
    public ResponseEntity<ResponseDTO> getCookie (HttpServletRequest request) {
        return ResponseEntity.ok(cookieService.getCookie(request));
    }

    @PostMapping("/set")
    public ResponseEntity<ResponseDTO> setCookie (@RequestBody JsonNode requestBody, HttpServletResponse response, HttpServletRequest request) {
        return ResponseEntity.ok(cookieService.setCookie(requestBody, response, request));
    }

    @DeleteMapping("/remove")
    public ResponseEntity<ResponseDTO> removeCookie (HttpServletRequest request, HttpServletResponse response, @RequestParam String cookieKey) {
        return ResponseEntity.ok(cookieService.removeCookie(request, response, cookieKey));
    }
}
