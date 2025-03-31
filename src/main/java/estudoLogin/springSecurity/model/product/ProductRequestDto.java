package estudoLogin.springSecurity.model.product;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record ProductRequestDto(
        @NotBlank
        String name,

        @Min(0)
        double price) {
}
