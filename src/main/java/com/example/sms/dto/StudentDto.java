package com.example.sms.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;

public record StudentDto(
        Long id,
        @NotBlank String firstName,
        @NotBlank String lastName,
        LocalDate birthDate,
        @Email String email,
        String phone,
        Long groupId
) {}
