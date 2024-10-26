package com.paras.FreeAPIs.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO {
    private String message;
    private Object data;
    private Status status;
    private String error;
    private Integer statusCode;
    private boolean success;

    public static ResponseDTO success (String message, Object data) {
        return ResponseDTO.builder()
                          .message(message)
                          .data(data)
                          .status(Status.SUCCESS)
                          .statusCode(200)
                          .success(true)
                          .build();
    }

    public static ResponseDTO error (String message, String error) {
        return ResponseDTO.builder()
                          .message(message)
                          .error(error)
                          .status(Status.ERROR)
                          .statusCode(500)
                          .success(false)
                          .build();
    }

    public static ResponseDTO failure (String message, Object data) {
        return ResponseDTO.builder()
                          .message(message)
                          .data(data)
                          .status(Status.FAILURE)
                          .statusCode(400)
                          .success(false)
                          .build();
    }

    public enum Status {
        SUCCESS, FAILURE, ERROR;
    }
}
