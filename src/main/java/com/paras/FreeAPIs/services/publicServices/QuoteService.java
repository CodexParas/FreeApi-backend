package com.paras.FreeAPIs.services.publicServices;

import com.paras.FreeAPIs.DTO.ResponseDTO;

public interface QuoteService {
    ResponseDTO getQuote (int page, int limit, String query, String inc);

    ResponseDTO getQuoteById (String id);

    ResponseDTO getRandomQuote ();
}
