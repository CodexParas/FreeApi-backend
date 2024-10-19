package com.paras.FreeAPIs.services.publicServices;

import com.paras.FreeAPIs.DTO.ResponseDTO;


public interface RandomJokeService {
    ResponseDTO getRandomJokes (int page, int limit, String query, String inc);

    ResponseDTO getJokeById (String id);

    ResponseDTO getRandomJoke ();
}
