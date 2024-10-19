package com.paras.FreeAPIs.controllers.publicControllers;

import com.paras.FreeAPIs.DTO.ResponseDTO;
import com.paras.FreeAPIs.services.publicServices.CatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cat")
@RequiredArgsConstructor
public class CatController extends PublicController {
    private final CatService catService;

    @GetMapping("/")
    public ResponseEntity<ResponseDTO> getCat
            (@RequestParam(value = "page", defaultValue = "1") int page,
             @RequestParam(value = "limit", defaultValue = "10") int limit,
             @RequestParam(value = "query", defaultValue = "") String query,
             @RequestParam(value = "inc", defaultValue = "") String inc
            ) {
        return ResponseEntity.ok(catService.getCat(page, limit, query, inc));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> getCatById
            (@PathVariable(value = "id") String id) {
        return ResponseEntity.ok(catService.getCatById(id));
    }

    @GetMapping("/cat/random")
    public ResponseEntity<ResponseDTO> getRandomCat () {
        return ResponseEntity.ok(catService.getRandomCat());
    }
}
