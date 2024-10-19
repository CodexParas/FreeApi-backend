package com.paras.FreeAPIs.controllers.publicControllers;

import com.paras.FreeAPIs.DTO.ResponseDTO;
import com.paras.FreeAPIs.services.publicServices.RandomProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/randomproducts")
@RequiredArgsConstructor
public class RandomProductController extends PublicController {
    private final RandomProductService randomProductService;

    @GetMapping("/")
    public ResponseEntity<ResponseDTO> getRandomProducts
            (@RequestParam(value = "page", defaultValue = "1") int page,
             @RequestParam(value = "limit", defaultValue = "10") int limit,
             @RequestParam(value = "query", defaultValue = "") String query,
             @RequestParam(value = "inc", defaultValue = "") String inc
            ) {
        return ResponseEntity.ok(randomProductService.getRandomProducts(page, limit, query, inc));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> getProductById
            (@PathVariable(value = "id") String id) {
        return ResponseEntity.ok(randomProductService.getProductById(id));
    }

    @GetMapping("/product/random")
    public ResponseEntity<ResponseDTO> getRandomProduct () {
        return ResponseEntity.ok(randomProductService.getRandomProduct());
    }
}
