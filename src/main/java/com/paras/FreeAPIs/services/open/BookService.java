package com.paras.FreeAPIs.services.open;

import com.paras.FreeAPIs.DTO.ResponseDTO;

public interface BookService {
    ResponseDTO getBooks (int page, int limit, String query, String inc);

    ResponseDTO getBookById (String id);

    ResponseDTO getRandomBook ();
}
