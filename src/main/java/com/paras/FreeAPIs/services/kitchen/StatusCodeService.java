package com.paras.FreeAPIs.services.kitchen;

import com.paras.FreeAPIs.DTO.ResponseDTO;

public interface StatusCodeService {
    ResponseDTO getAllStatusCodes ();

    ResponseDTO getStatusCode (String code);
}
