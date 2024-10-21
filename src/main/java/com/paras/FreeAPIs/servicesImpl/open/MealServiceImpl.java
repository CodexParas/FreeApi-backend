package com.paras.FreeAPIs.servicesImpl.open;

import com.fasterxml.jackson.databind.JsonNode;
import com.paras.FreeAPIs.DTO.ResponseDTO;
import com.paras.FreeAPIs.services.open.MealService;
import com.paras.FreeAPIs.utils.JsonSupplier;
import com.paras.FreeAPIs.utils.PublicUtilities;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MealServiceImpl implements MealService {
    private final JsonSupplier jsonSupplier;
    private final PublicUtilities publicUtilities;
    private JsonNode meals;

    public ResponseDTO getMeal (int page, int limit, String query, String inc) {
        if (meals == null) {
            meals = jsonSupplier.getJson("meals");
        }
        return ResponseDTO.success(
                "Meals fetched successfully",
                publicUtilities.getPagedData(meals, page, limit));
    }

    public ResponseDTO getMealById (String id) {
        if (meals == null) {
            meals = jsonSupplier.getJson("meals");
        }
        Optional<JsonNode> mealOptional = publicUtilities.findById(id, meals);
        if (mealOptional.isPresent()) {
            return ResponseDTO.success(
                    "Meal fetched successfully",
                    mealOptional.get());
        }
        return ResponseDTO.failure("Meal not found", null);
    }

    public ResponseDTO getRandomMeal () {
        if (meals == null) {
            meals = jsonSupplier.getJson("meals");
        }
        int randomIndex = (int) (Math.random() * meals.size());
        return ResponseDTO.success(
                "Random meal fetched successfully",
                meals.get(randomIndex));
    }
}
