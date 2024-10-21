package com.paras.FreeAPIs.servicesImpl.open;

import com.fasterxml.jackson.databind.JsonNode;
import com.paras.FreeAPIs.DTO.ResponseDTO;
import com.paras.FreeAPIs.services.open.RandomUserService;
import com.paras.FreeAPIs.utils.JsonSupplier;
import com.paras.FreeAPIs.utils.PublicUtilities;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RandomUserServiceImpl implements RandomUserService {
    private final JsonSupplier jsonSupplier;
    private final PublicUtilities publicUtilities;
    private JsonNode randomUsers;

    public ResponseDTO getRandomUsers (int page, int limit, String query, String inc) {
        if (randomUsers == null) {
            randomUsers = jsonSupplier.getJson("randomuser");
        }
        return ResponseDTO.success("Users fetched successfully", publicUtilities.getPagedData(randomUsers, page, limit));
    }

    public ResponseDTO getUserById (String id) {
        if (randomUsers == null) {
            randomUsers = jsonSupplier.getJson("randomuser");
        }
        Optional<JsonNode> userOptional = publicUtilities.findById(id, randomUsers);
        if (userOptional.isPresent()) {
            return ResponseDTO.success("User fetched successfully", userOptional.get());
        }
        return ResponseDTO.failure("User not found", null);
    }

    public ResponseDTO getRandomUser () {
        if (randomUsers == null) {
            randomUsers = jsonSupplier.getJson("randomuser");
        }
        int randomIndex = (int) (Math.random() * randomUsers.size());
        return ResponseDTO.success("Random user fetched successfully", randomUsers.get(randomIndex));
    }
}
