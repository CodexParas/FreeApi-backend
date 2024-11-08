package com.paras.FreeAPIs.services.open;

import com.paras.FreeAPIs.DTO.ResponseDTO;

public interface StockService {
    ResponseDTO getStock (int page, int limit, String query, String inc);

    ResponseDTO getStockById (String id);

    ResponseDTO getRandomStock ();
}
