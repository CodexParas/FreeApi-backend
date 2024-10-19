package com.paras.FreeAPIs.servicesImpl.publicServicesImpl;

import com.fasterxml.jackson.databind.JsonNode;
import com.paras.FreeAPIs.DTO.ResponseDTO;
import com.paras.FreeAPIs.json.JsonSupplier;
import com.paras.FreeAPIs.services.publicServices.RandomUserService;
import com.paras.FreeAPIs.utils.PublicUtilities;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RandomUserServiceImpl implements RandomUserService {
    private final JsonSupplier jsonSupplier;
    private final PublicUtilities publicUtilities;
    private final JsonNode randomUsers = jsonSupplier.getJson("randomuser");

    public ResponseDTO getRandomUsers (int page, int limit, String query, String inc) {
        return ResponseDTO.success("Users fetched successfully", publicUtilities.getPagedData(randomUsers, page, limit));
    }

    public ResponseDTO getUserById (String id) {
        Optional<JsonNode> userOptional = publicUtilities.findById(id, randomUsers);
        if (userOptional.isPresent()) {
            return ResponseDTO.success("User fetched successfully", userOptional.get());
        }
        return ResponseDTO.failure("User not found", null);
    }

    public ResponseDTO getRandomUser () {
        int randomIndex = (int) (Math.random() * randomUsers.size());
        return ResponseDTO.success("Random user fetched successfully", randomUsers.get(randomIndex));
    }
}
