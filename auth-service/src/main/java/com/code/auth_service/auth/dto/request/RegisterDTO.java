package com.code.auth_service.auth.dto.request;

import com.code.auth_service.auth.dto.customValidation.emailExist.EmailExist;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDTO {


    @NotBlank
    @EmailExist
    private String email;

    @NotBlank
    private String name;
    
    @NotBlank
    // @Min(value=7)
    // @Max(value=12)
    private String password;
}
