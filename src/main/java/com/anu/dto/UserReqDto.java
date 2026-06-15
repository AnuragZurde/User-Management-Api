package com.anu.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserReqDto {
    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @Email
    private String email;
}
