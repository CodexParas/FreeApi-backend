package com.paras.FreeAPIs.servicesImpl.publicServicesImpl;

import com.fasterxml.jackson.databind.JsonNode;
import com.paras.FreeAPIs.DTO.ResponseDTO;
import com.paras.FreeAPIs.json.JsonSupplier;
import com.paras.FreeAPIs.services.publicServices.MealService;
import com.paras.FreeAPIs.utils.PublicUtilities;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MealServiceImpl implements MealService {
    private final JsonSupplier jsonSupplier;
    private final PublicUtilities publicUtilities;
    private final JsonNode meals = jsonSupplier.getJson("meals");

    public ResponseDTO getMeal (int page, int limit, String query, String inc) {
        return ResponseDTO.success(
                "Meals fetched successfully",
                publicUtilities.getPagedData(meals, page, limit));
    }

    public ResponseDTO getMealById (String id) {
        Optional<JsonNode> mealOptional = publicUtilities.findById(id, meals);
        if (mealOptional.isPresent()) {
            return ResponseDTO.success(
                    "Meal fetched successfully",
                    mealOptional.get());
        }
        return ResponseDTO.failure("Meal not found", null);
    }

    public ResponseDTO getRandomMeal () {
        int randomIndex = (int) (Math.random() * meals.size());
        return ResponseDTO.success(
                "Random meal fetched successfully",
                meals.get(randomIndex));
    }
}
