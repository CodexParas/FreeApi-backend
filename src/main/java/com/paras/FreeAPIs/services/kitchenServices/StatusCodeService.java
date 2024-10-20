package com.paras.FreeAPIs.services.kitchenServices;

import com.paras.FreeAPIs.DTO.ResponseDTO;

public interface StatusCodeService {
    ResponseDTO getAllStatusCodes ();

    ResponseDTO getStatusCode (String code);
}
