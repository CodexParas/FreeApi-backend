package com.paras.FreeAPIs.utils;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Component
public class PublicUtilities {
    public List<JsonNode> getPagedData (JsonNode node, int page, int limit) {
        int start = Math.max(0, page * limit);
        if (start >= node.size()) {
            return new ArrayList<>();
        }
        int end = Math.min(start + limit, node.size());
        List<JsonNode> nodeList = new ArrayList<>();
        for (int i = start; i < end; i++) {
            nodeList.add(node.get(i));
        }
        return nodeList;
    }

    public Optional<JsonNode> findById (String id, JsonNode node) {
        return StreamSupport.stream(node.spliterator(), false)
                            .filter(book -> book.get("id").asText().equals(id))
                            .findFirst();
    }
}
