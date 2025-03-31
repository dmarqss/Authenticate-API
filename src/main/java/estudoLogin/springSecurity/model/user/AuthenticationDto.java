package estudoLogin.springSecurity.model.user;

import jakarta.validation.constraints.NotBlank;

public record AuthenticationDto(
        @NotBlank
        String username,

        @NotBlank
        String password

) {
}
