package estudoLogin.springSecurity.model.user;

import jakarta.validation.constraints.NotBlank;

public record RegisterDto(
        @NotBlank
        String username,

        @NotBlank
        String password,


        UserRole role


) {
}
