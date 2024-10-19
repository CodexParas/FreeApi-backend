package com.paras.FreeAPIs.servicesImpl.publicServicesImpl;

import com.fasterxml.jackson.databind.JsonNode;
import com.paras.FreeAPIs.DTO.ResponseDTO;
import com.paras.FreeAPIs.json.JsonSupplier;
import com.paras.FreeAPIs.services.publicServices.BookService;
import com.paras.FreeAPIs.utils.PublicUtilities;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BooksServiceImpl implements BookService {
    private final JsonSupplier jsonSupplier;
    private final PublicUtilities publicUtilities;
    private final JsonNode books = jsonSupplier.getJson("books");

    public ResponseDTO getBooks (int page, int limit, String query, String inc) {
        return ResponseDTO.success(
                "Books fetched successfully",
                publicUtilities.getPagedData(books, page, limit));
    }

    public ResponseDTO getBookById (String id) {
        Optional<JsonNode> bookOptional = publicUtilities.findById(id, books);
        if (bookOptional.isPresent()) {
            return ResponseDTO.success(
                    "Book fetched successfully",
                    bookOptional.get());
        }
        return ResponseDTO.failure("Book not found", null);
    }

    public ResponseDTO getRandomBook () {
        final int randomIndex = (int) (Math.random() * books.size());
        return ResponseDTO.success(
                "Random book fetched successfully",
                books.get(randomIndex));
    }
}
