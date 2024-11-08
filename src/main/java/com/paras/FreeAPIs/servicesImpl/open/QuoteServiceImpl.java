package com.paras.FreeAPIs.servicesImpl.open;

import com.fasterxml.jackson.databind.JsonNode;
import com.paras.FreeAPIs.DTO.ResponseDTO;
import com.paras.FreeAPIs.services.open.QuoteService;
import com.paras.FreeAPIs.utils.JsonSupplier;
import com.paras.FreeAPIs.utils.PublicUtilities;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuoteServiceImpl implements QuoteService {
    private final JsonSupplier jsonSupplier;
    private final PublicUtilities publicUtilities;
    private JsonNode quotes;

    public ResponseDTO getQuote (int page, int limit, String query, String inc) {
        if (quotes == null) {
            quotes = jsonSupplier.getJson("quotes");
        }
        return ResponseDTO.success(
                "Quotes fetched successfully",
                publicUtilities.getPagedData(quotes, page, limit));
    }

    public ResponseDTO getQuoteById (String id) {
        if (quotes == null) {
            quotes = jsonSupplier.getJson("quotes");
        }
        Optional<JsonNode> quoteOptional = publicUtilities.findById(id, quotes);
        if (quoteOptional.isPresent()) {
            return ResponseDTO.success(
                    "Quote fetched successfully",
                    quoteOptional.get());
        }
        return ResponseDTO.failure("Quote not found", null);
    }

    public ResponseDTO getRandomQuote () {
        if (quotes == null) {
            quotes = jsonSupplier.getJson("quotes");
        }
        int randomIndex = (int) (Math.random() * quotes.size());
        return ResponseDTO.success(
                "Random Quote fetched successfully",
                quotes.get(randomIndex));
    }
}
