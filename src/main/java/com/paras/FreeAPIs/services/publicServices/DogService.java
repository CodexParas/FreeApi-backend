package com.paras.FreeAPIs.services.publicServices;

import com.paras.FreeAPIs.DTO.ResponseDTO;

public interface DogService {
    ResponseDTO getDog (int page, int limit, String query, String inc);

    ResponseDTO getDogById (String id);

    ResponseDTO getRandomDog ();
}
