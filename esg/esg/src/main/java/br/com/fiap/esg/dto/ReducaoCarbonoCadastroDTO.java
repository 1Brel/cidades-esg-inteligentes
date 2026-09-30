package br.com.fiap.esg.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public record ReducaoCarbonoCadastroDTO(
        @NotBlank(message = "A descrição é obrigatória")
        String descricao,

        @NotBlank(message = "A categoria é obrigatória")
        String categoria,

        @NotBlank(message = "O status é obrigatório")
        String status,

        @PositiveOrZero
        BigDecimal emissaoBaseTco2E,

        @PositiveOrZero
        BigDecimal metaReducaoTco2E
) {
}
