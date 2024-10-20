package com.paras.FreeAPIs.controllers.kitchenControllers;

import com.paras.FreeAPIs.DTO.RequestMethodDTO;
import com.paras.FreeAPIs.DTO.ResponseDTO;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/http-methods")
@RequiredArgsConstructor
public class HttpMethodsController extends KitchenController {

    @GetMapping("/get")
    public ResponseEntity<ResponseDTO> get (HttpServletRequest request) {
        return ResponseEntity.ok(
                ResponseDTO.success(
                        "GET request",
                        RequestMethodDTO.from(request)));
    }

    @PostMapping("/post")
    public ResponseEntity<ResponseDTO> post (HttpServletRequest request) {
        return ResponseEntity.ok(
                ResponseDTO.success(
                        "POST request",
                        RequestMethodDTO.from(request)));
    }

    @PutMapping("/put")
    public ResponseEntity<ResponseDTO> put (HttpServletRequest request) {
        return ResponseEntity.ok(
                ResponseDTO.success(
                        "PUT request",
                        RequestMethodDTO.from(request)));
    }

    @PatchMapping("/patch")
    public ResponseEntity<ResponseDTO> patch (HttpServletRequest request) {
        return ResponseEntity.ok(
                ResponseDTO.success(
                        "PATCH request",
                        RequestMethodDTO.from(request)));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> delete (HttpServletRequest request) {
        return ResponseEntity.ok(
                ResponseDTO.success(
                        "DELETE request",
                        RequestMethodDTO.from(request)));
    }
}
