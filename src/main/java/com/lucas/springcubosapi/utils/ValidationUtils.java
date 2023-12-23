package com.lucas.springcubosapi.utils;

import com.lucas.springcubosapi.dtos.ClientDTO;

public class ValidationUtils {
    public static void validateRequiredField(Object fieldValue, String errorMessage) {
        if (fieldValue == null || (fieldValue instanceof String && ((String) fieldValue).isEmpty())) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static void ValidateClientData(ClientDTO data) {
        ValidationUtils.validateRequiredField(data.firstName(), "Client name is required");
        ValidationUtils.validateRequiredField(data.lastName(), "Client lastname is required");
        ValidationUtils.validateRequiredField(data.participation(), "Client participation is required");
    }
}
