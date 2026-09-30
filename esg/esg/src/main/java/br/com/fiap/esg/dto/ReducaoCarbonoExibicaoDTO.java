package br.com.fiap.esg.dto;

import br.com.fiap.esg.model.ReducaoCarbono;

import java.math.BigDecimal;

public record ReducaoCarbonoExibicaoDTO(
        Long reducaoCarbonoId,
        String descricao,
        String categoria,
        String status,
        BigDecimal emissaoBaseTco2E,
        BigDecimal metaReducaoTco2E
) {
    public ReducaoCarbonoExibicaoDTO(ReducaoCarbono reducaoCarbono) {
        this(
                reducaoCarbono.getReducaoCarbonoId(),
                reducaoCarbono.getDescricao(),
                reducaoCarbono.getCategoria(),
                reducaoCarbono.getStatus(),
                reducaoCarbono.getEmissaoBaseTco2E(),
                reducaoCarbono.getMetaReducaoTco2E());
    }
}
