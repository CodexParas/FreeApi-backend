package com.paras.FreeAPIs.controllers.publicControllers;

import com.paras.FreeAPIs.DTO.ResponseDTO;
import com.paras.FreeAPIs.services.publicServices.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController extends PublicController {

    private final BookService bookService;

    @GetMapping("/")
    public ResponseEntity<ResponseDTO> getBooks
            (@RequestParam(value = "page", defaultValue = "1") int page,
             @RequestParam(value = "limit", defaultValue = "10") int limit,
             @RequestParam(value = "query", defaultValue = "") String query,
             @RequestParam(value = "inc", defaultValue = "") String inc
            ) {
        return ResponseEntity.ok(bookService.getBooks(page, limit, query, inc));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> getBookById
            (@PathVariable(value = "id") String id) {
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    @GetMapping("/book/random")
    public ResponseEntity<ResponseDTO> getRandomBook () {
        return ResponseEntity.ok(bookService.getRandomBook());
    }
}
