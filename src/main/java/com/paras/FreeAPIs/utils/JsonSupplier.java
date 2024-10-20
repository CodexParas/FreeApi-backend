package com.paras.FreeAPIs.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.paras.FreeAPIs.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

@Component
@RequiredArgsConstructor
public class JsonSupplier {
    private final ObjectMapper objectMapper;

    @SneakyThrows
    public JsonNode getJson (String name) {
        InputStream inputStream = getClass().getResourceAsStream("/json/" + name + ".json");
        try (inputStream) {
            if (inputStream == null) {
                throw new ResourceNotFoundException("Unable to fetch " + name + " data. Resource not found.");
            }
            return objectMapper.readTree(inputStream);
        } catch (IOException e) {
            throw new ResourceNotFoundException("Error reading JSON data for " + name);
        }
    }
}