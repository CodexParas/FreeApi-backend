package com.paras.FreeAPIs.servicesImpl.publicServicesImpl;

import com.fasterxml.jackson.databind.JsonNode;
import com.paras.FreeAPIs.DTO.ResponseDTO;
import com.paras.FreeAPIs.json.JsonSupplier;
import com.paras.FreeAPIs.services.publicServices.QuoteService;
import com.paras.FreeAPIs.utils.PublicUtilities;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuoteServiceImpl implements QuoteService {
    private final JsonSupplier jsonSupplier;
    private final PublicUtilities publicUtilities;
    private final JsonNode quotes = jsonSupplier.getJson("quotes");

    public ResponseDTO getQuote (int page, int limit, String query, String inc) {
        return ResponseDTO.success(
                "Quotes fetched successfully",
                publicUtilities.getPagedData(quotes, page, limit));
    }

    public ResponseDTO getQuoteById (String id) {
        Optional<JsonNode> quoteOptional = publicUtilities.findById(id, quotes);
        if (quoteOptional.isPresent()) {
            return ResponseDTO.success(
                    "Quote fetched successfully",
                    quoteOptional.get());
        }
        return ResponseDTO.failure("Quote not found", null);
    }

    public ResponseDTO getRandomQuote () {
        int randomIndex = (int) (Math.random() * quotes.size());
        return ResponseDTO.success(
                "Random Quote fetched successfully",
                quotes.get(randomIndex));
    }
}
