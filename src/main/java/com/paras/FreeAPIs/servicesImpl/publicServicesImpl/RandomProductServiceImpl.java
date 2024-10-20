package com.paras.FreeAPIs.servicesImpl.publicServicesImpl;

import com.fasterxml.jackson.databind.JsonNode;
import com.paras.FreeAPIs.DTO.ResponseDTO;
import com.paras.FreeAPIs.services.publicServices.RandomProductService;
import com.paras.FreeAPIs.utils.JsonSupplier;
import com.paras.FreeAPIs.utils.PublicUtilities;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RandomProductServiceImpl implements RandomProductService {
    private final JsonSupplier jsonSupplier;
    private final PublicUtilities publicUtilities;
    private JsonNode randomProducts;

    public ResponseDTO getRandomProducts (int page, int limit, String query, String inc) {
        if (randomProducts == null) {
            randomProducts = jsonSupplier.getJson("randomproduct");
        }
        return ResponseDTO.success("Products fetched successfully", publicUtilities.getPagedData(randomProducts, page, limit));
    }

    public ResponseDTO getProductById (String id) {
        if (randomProducts == null) {
            randomProducts = jsonSupplier.getJson("randomproduct");
        }
        Optional<JsonNode> productOptional = publicUtilities.findById(id, randomProducts);
        if (productOptional.isPresent()) {
            return ResponseDTO.success("Product fetched successfully", productOptional.get());
        }
        return ResponseDTO.failure("Product not found", null);
    }

    public ResponseDTO getRandomProduct () {
        if (randomProducts == null) {
            randomProducts = jsonSupplier.getJson("randomproduct");
        }
        int randomIndex = (int) (Math.random() * randomProducts.size());
        return ResponseDTO.success("Random product fetched successfully", randomProducts.get(randomIndex));
    }
}
