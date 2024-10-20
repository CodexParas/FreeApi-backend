package com.paras.FreeAPIs.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


public record TodoRequestDTO(
        @NotNull(message = "Title is required")
        @NotEmpty(message = "Title is required")
        String title,
        @NotNull(message = "Description is required")
        @NotEmpty(message = "Description is required")
        String description
) {

}
