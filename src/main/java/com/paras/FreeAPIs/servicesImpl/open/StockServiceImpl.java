package com.paras.FreeAPIs.servicesImpl.open;

import com.fasterxml.jackson.databind.JsonNode;
import com.paras.FreeAPIs.DTO.ResponseDTO;
import com.paras.FreeAPIs.services.open.StockService;
import com.paras.FreeAPIs.utils.JsonSupplier;
import com.paras.FreeAPIs.utils.PublicUtilities;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StockServiceImpl implements StockService {
    private final JsonSupplier jsonSupplier;
    private final PublicUtilities publicUtilities;
    private JsonNode stocks;

    public ResponseDTO getStock (int page, int limit, String query, String inc) {
        if (stocks == null) {
            stocks = jsonSupplier.getJson("nse-stocks");
        }
        return ResponseDTO.success("Stocks fetched successfully", publicUtilities.getPagedData(stocks, page, limit));
    }

    public ResponseDTO getStockById (String id) {
        if (stocks == null) {
            stocks = jsonSupplier.getJson("nse-stocks");
        }
        Optional<JsonNode> stockOptional = publicUtilities.findById(id, stocks);
        if (stockOptional.isPresent()) {
            return ResponseDTO.success("Stock fetched successfully", stockOptional.get());
        }
        return ResponseDTO.failure("Stock not found", null);
    }

    public ResponseDTO getRandomStock () {
        if (stocks == null) {
            stocks = jsonSupplier.getJson("nse-stocks");
        }
        int randomIndex = (int) (Math.random() * stocks.size());
        return ResponseDTO.success("Random stock fetched successfully", stocks.get(randomIndex));
    }
}
