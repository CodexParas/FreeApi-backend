package com.paras.FreeAPIs.controllers.kitchenControllers;

import com.paras.FreeAPIs.DTO.ResponseDTO;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/redirect")
@RequiredArgsConstructor
public class RedirectController extends KitchenController {

    @GetMapping("/to")
    public ResponseEntity<ResponseDTO> redirectTo (HttpServletResponse response, @RequestParam String url) {
        try {
            response.sendRedirect(url);
        } catch (IOException e) {
            return ResponseEntity.badRequest().body(ResponseDTO.error("Failed to redirect", e.getMessage()));
        }
        return ResponseEntity.ok(ResponseDTO.success("Redirected to " + url, null));
    }
}
