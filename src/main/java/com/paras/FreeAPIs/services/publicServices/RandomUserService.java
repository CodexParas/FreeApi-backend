package com.paras.FreeAPIs.services.publicServices;


import com.paras.FreeAPIs.DTO.ResponseDTO;


public interface RandomUserService {
    ResponseDTO getRandomUsers (int page, int limit, String query, String inc);

    ResponseDTO getUserById (String id);

    ResponseDTO getRandomUser ();
}
