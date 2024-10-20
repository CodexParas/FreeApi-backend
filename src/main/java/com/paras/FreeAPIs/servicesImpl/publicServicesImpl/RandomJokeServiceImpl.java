package com.paras.FreeAPIs.servicesImpl.publicServicesImpl;

import com.fasterxml.jackson.databind.JsonNode;
import com.paras.FreeAPIs.DTO.ResponseDTO;
import com.paras.FreeAPIs.services.publicServices.RandomJokeService;
import com.paras.FreeAPIs.utils.JsonSupplier;
import com.paras.FreeAPIs.utils.PublicUtilities;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RandomJokeServiceImpl implements RandomJokeService {
    private final JsonSupplier jsonSupplier;
    private final PublicUtilities publicUtilities;
    private JsonNode randomJokes;

    public ResponseDTO getRandomJokes (int page, int limit, String query, String inc) {
        if (randomJokes == null) {
            randomJokes = jsonSupplier.getJson("randomjoke");
        }
        return ResponseDTO.success("Jokes fetched successfully", publicUtilities.getPagedData(randomJokes, page, limit));
    }

    public ResponseDTO getJokeById (String id) {
        if (randomJokes == null) {
            randomJokes = jsonSupplier.getJson("randomjoke");
        }
        Optional<JsonNode> jokeOptional = publicUtilities.findById(id, randomJokes);
        if (jokeOptional.isPresent()) {
            return ResponseDTO.success("Joke fetched successfully", jokeOptional.get());
        }
        return ResponseDTO.failure("Joke not found", null);
    }

    public ResponseDTO getRandomJoke () {
        if (randomJokes == null) {
            randomJokes = jsonSupplier.getJson("randomjoke");
        }
        int randomIndex = (int) (Math.random() * randomJokes.size());
        return ResponseDTO.success("Random joke fetched successfully", randomJokes.get(randomIndex));
    }
}
