package com.paras.FreeAPIs.controllers.open;

import com.paras.FreeAPIs.DTO.ResponseDTO;
import com.paras.FreeAPIs.services.open.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stock")
@RequiredArgsConstructor
public class StockController extends PublicController {
    private final StockService stockService;

    @GetMapping("/")
    public ResponseEntity<ResponseDTO> getStock
            (@RequestParam(value = "page", defaultValue = "1") int page,
             @RequestParam(value = "limit", defaultValue = "10") int limit,
             @RequestParam(value = "query", defaultValue = "") String query,
             @RequestParam(value = "inc", defaultValue = "") String inc
            ) {
        return ResponseEntity.ok(stockService.getStock(page, limit, query, inc));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> getStockById
            (@PathVariable(value = "id") String id) {
        return ResponseEntity.ok(stockService.getStockById(id));
    }

    @GetMapping("/stock/random")
    public ResponseEntity<ResponseDTO> getRandomStock () {
        return ResponseEntity.ok(stockService.getRandomStock());
    }
}
