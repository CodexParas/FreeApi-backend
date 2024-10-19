package com.paras.FreeAPIs.controllers.publicControllers;

import com.paras.FreeAPIs.DTO.ResponseDTO;
import com.paras.FreeAPIs.services.publicServices.DogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dog")
@RequiredArgsConstructor
public class DogController extends PublicController {
    private final DogService dogService;

    @GetMapping("/")
    public ResponseEntity<ResponseDTO> getDog
            (@RequestParam(value = "page", defaultValue = "1") int page,
             @RequestParam(value = "limit", defaultValue = "10") int limit,
             @RequestParam(value = "query", defaultValue = "") String query,
             @RequestParam(value = "inc", defaultValue = "") String inc
            ) {
        return ResponseEntity.ok(dogService.getDog(page, limit, query, inc));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> getDogById
            (@PathVariable(value = "id") String id) {
        return ResponseEntity.ok(dogService.getDogById(id));
    }

    @GetMapping("/dog/random")
    public ResponseEntity<ResponseDTO> getRandomDog () {
        return ResponseEntity.ok(dogService.getRandomDog());
    }
}
