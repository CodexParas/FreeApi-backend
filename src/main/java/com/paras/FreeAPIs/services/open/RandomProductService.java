package com.paras.FreeAPIs.services.open;

import com.paras.FreeAPIs.DTO.ResponseDTO;


public interface RandomProductService {
    ResponseDTO getRandomProducts (int page, int limit, String query, String inc);

    ResponseDTO getProductById (String id);

    ResponseDTO getRandomProduct ();
}
