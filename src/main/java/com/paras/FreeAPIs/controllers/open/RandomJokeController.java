package com.paras.FreeAPIs.controllers.open;

import com.paras.FreeAPIs.DTO.ResponseDTO;
import com.paras.FreeAPIs.services.open.RandomJokeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/randomjokes")
@RequiredArgsConstructor
public class RandomJokeController extends PublicController {
    private final RandomJokeService randomJokeService;

    @GetMapping("/")
    public ResponseEntity<ResponseDTO> getRandomJokes
            (@RequestParam(value = "page", defaultValue = "1") int page,
             @RequestParam(value = "limit", defaultValue = "10") int limit,
             @RequestParam(value = "query", defaultValue = "") String query,
             @RequestParam(value = "inc", defaultValue = "") String inc
            ) {
        return ResponseEntity.ok(randomJokeService.getRandomJokes(page, limit, query, inc));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> getJokeById
            (@PathVariable(value = "id") String id) {
        return ResponseEntity.ok(randomJokeService.getJokeById(id));
    }

    @GetMapping("/joke/random")
    public ResponseEntity<ResponseDTO> getRandomJoke () {
        return ResponseEntity.ok(randomJokeService.getRandomJoke());
    }
}
