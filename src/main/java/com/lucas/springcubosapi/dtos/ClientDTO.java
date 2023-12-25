package com.lucas.springcubosapi.dtos;

import java.math.BigDecimal;

public record ClientDTO(String firstName, String lastName, BigDecimal participation) {
    @Override
    public String firstName() {
        return firstName;
    }

    @Override
    public String lastName() {
        return lastName;
    }

    @Override
    public BigDecimal participation() {
        return participation;
    }
}
