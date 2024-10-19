package com.paras.FreeAPIs.controllers.publicControllers;

import com.paras.FreeAPIs.DTO.ResponseDTO;
import com.paras.FreeAPIs.services.publicServices.QuoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quote")
@RequiredArgsConstructor
public class QuoteController extends PublicController {

    private final QuoteService quoteService;

    @GetMapping("/")
    public ResponseEntity<ResponseDTO> getQuote
            (@RequestParam(value = "page", defaultValue = "1") int page,
             @RequestParam(value = "limit", defaultValue = "10") int limit,
             @RequestParam(value = "query", defaultValue = "") String query,
             @RequestParam(value = "inc", defaultValue = "") String inc
            ) {
        return ResponseEntity.ok(quoteService.getQuote(page, limit, query, inc));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> getQuoteById
            (@PathVariable(value = "id") String id) {
        return ResponseEntity.ok(quoteService.getQuoteById(id));
    }

    @GetMapping("/quote/random")
    public ResponseEntity<ResponseDTO> getRandomQuote () {
        return ResponseEntity.ok(quoteService.getRandomQuote());
    }

}
