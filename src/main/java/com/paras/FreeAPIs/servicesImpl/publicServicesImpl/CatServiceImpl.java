package com.paras.FreeAPIs.servicesImpl.publicServicesImpl;

import com.fasterxml.jackson.databind.JsonNode;
import com.paras.FreeAPIs.DTO.ResponseDTO;
import com.paras.FreeAPIs.json.JsonSupplier;
import com.paras.FreeAPIs.services.publicServices.CatService;
import com.paras.FreeAPIs.utils.PublicUtilities;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CatServiceImpl implements CatService {
    private final JsonSupplier jsonSupplier;
    private final PublicUtilities publicUtilities;
    private final JsonNode cats = jsonSupplier.getJson("cats");

    public ResponseDTO getCat (int page, int limit, String query, String inc) {
        return ResponseDTO.success(
                "Cats fetched successfully",
                publicUtilities.getPagedData(cats, page, limit));
    }

    public ResponseDTO getCatById (String id) {
        Optional<JsonNode> catOptional = publicUtilities.findById(id, cats);
        if (catOptional.isPresent()) {
            return ResponseDTO.success(
                    "Cat fetched successfully",
                    catOptional.get());
        }
        return ResponseDTO.failure(
                "Cat not found",
                null);
    }

    // todo: implement getRandomCat
    public ResponseDTO getRandomCat () {
        final int randomIndex = (int) (Math.random() * cats.size());
        return ResponseDTO.success(
                "Random cat fetched successfully",
                cats.get(randomIndex));
    }
}
