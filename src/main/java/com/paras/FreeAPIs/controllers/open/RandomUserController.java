package com.paras.FreeAPIs.controllers.open;

import com.paras.FreeAPIs.DTO.ResponseDTO;
import com.paras.FreeAPIs.services.open.RandomUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/randomusers")
@RequiredArgsConstructor
public class RandomUserController extends PublicController {

    private final RandomUserService randomUserService;

    @GetMapping("/")
    public ResponseEntity<ResponseDTO> getRandomUsers
            (@RequestParam(value = "page", defaultValue = "1") int page,
             @RequestParam(value = "limit", defaultValue = "10") int limit,
             @RequestParam(value = "query", defaultValue = "") String query,
             @RequestParam(value = "inc", defaultValue = "") String inc
            ) {
        return ResponseEntity.ok(randomUserService.getRandomUsers(page, limit, query, inc));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> getUserById
            (@PathVariable(value = "id") String id) {
        return ResponseEntity.ok(randomUserService.getUserById(id));
    }

    @GetMapping("/user/random")
    public ResponseEntity<ResponseDTO> getRandomUser () {
        return ResponseEntity.ok(randomUserService.getRandomUser());
    }
}
