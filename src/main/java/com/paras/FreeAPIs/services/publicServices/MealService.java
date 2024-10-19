package com.paras.FreeAPIs.services.publicServices;

import com.paras.FreeAPIs.DTO.ResponseDTO;

public interface MealService {
    ResponseDTO getMeal (int page, int limit, String query, String inc);

    ResponseDTO getMealById (String id);

    ResponseDTO getRandomMeal ();
}
