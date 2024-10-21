package com.paras.FreeAPIs.controllers.open;

import com.paras.FreeAPIs.DTO.ResponseDTO;
import com.paras.FreeAPIs.services.open.MealService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/meal")
@RequiredArgsConstructor
public class MealController extends PublicController {

    private final MealService mealService;

    @GetMapping("/")
    public ResponseEntity<ResponseDTO> getMeal
            (@RequestParam(value = "page", defaultValue = "1") int page,
             @RequestParam(value = "limit", defaultValue = "10") int limit,
             @RequestParam(value = "query", defaultValue = "") String query,
             @RequestParam(value = "inc", defaultValue = "") String inc
            ) {
        return ResponseEntity.ok(mealService.getMeal(page, limit, query, inc));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> getMealById
            (@PathVariable(value = "id") String id) {
        return ResponseEntity.ok(mealService.getMealById(id));
    }

    @GetMapping("/meal/random")
    public ResponseEntity<ResponseDTO> getRandomMeal () {
        return ResponseEntity.ok(mealService.getRandomMeal());
    }
}
