package com.paras.FreeAPIs.services.open;

import com.paras.FreeAPIs.DTO.ResponseDTO;

public interface CatService {
    ResponseDTO getCat (int page, int limit, String query, String inc);

    ResponseDTO getCatById (String id);

    ResponseDTO getRandomCat ();
}
