package com.paras.FreeAPIs.servicesImpl.publicServicesImpl;

import com.fasterxml.jackson.databind.JsonNode;
import com.paras.FreeAPIs.DTO.ResponseDTO;
import com.paras.FreeAPIs.json.JsonSupplier;
import com.paras.FreeAPIs.services.publicServices.StockService;
import com.paras.FreeAPIs.utils.PublicUtilities;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StockServiceImpl implements StockService {
    private final JsonSupplier jsonSupplier;
    private final PublicUtilities publicUtilities;
    private final JsonNode stocks = jsonSupplier.getJson("nse-stocks");

    public ResponseDTO getStock (int page, int limit, String query, String inc) {
        return ResponseDTO.success("Stocks fetched successfully", publicUtilities.getPagedData(stocks, page, limit));
    }

    public ResponseDTO getStockById (String id) {
        Optional<JsonNode> stockOptional = publicUtilities.findById(id, stocks);
        if (stockOptional.isPresent()) {
            return ResponseDTO.success("Stock fetched successfully", stockOptional.get());
        }
        return ResponseDTO.failure("Stock not found", null);
    }

    public ResponseDTO getRandomStock () {
        int randomIndex = (int) (Math.random() * stocks.size());
        return ResponseDTO.success("Random stock fetched successfully", stocks.get(randomIndex));
    }
}
