package com.paras.FreeAPIs.servicesImpl.publicServicesImpl;

import com.fasterxml.jackson.databind.JsonNode;
import com.paras.FreeAPIs.DTO.ResponseDTO;
import com.paras.FreeAPIs.json.JsonSupplier;
import com.paras.FreeAPIs.services.publicServices.DogService;
import com.paras.FreeAPIs.utils.PublicUtilities;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DogServiceImpl implements DogService {
    private final JsonSupplier jsonSupplier;
    private final PublicUtilities publicUtilities;
    private final JsonNode dogs = jsonSupplier.getJson("dogs");

    public ResponseDTO getDog (int page, int limit, String query, String inc) {
        return ResponseDTO.success(
                "Dogs fetched successfully",
                publicUtilities.getPagedData(dogs, page, limit));
    }

    public ResponseDTO getDogById (String id) {
        Optional<JsonNode> dogOptional = publicUtilities.findById(id, dogs);
        if (dogOptional.isPresent()) {
            return ResponseDTO.success("Dog fetched successfully", dogOptional.get());
        }
        return ResponseDTO.failure("Dog not found", null);

    }

    public ResponseDTO getRandomDog () {
        final int randomIndex = (int) (Math.random() * dogs.size());
        return ResponseDTO.success("Random dog fetched successfully", dogs.get(randomIndex));
    }
}
