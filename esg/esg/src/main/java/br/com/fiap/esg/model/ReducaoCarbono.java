package br.com.fiap.esg.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "TBL_INICIATIVA_REDUCAO_CARBONO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ReducaoCarbono {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_CARBONO"
    )
    @SequenceGenerator(
            name = "SEQ_CARBONO",
            sequenceName = "SEQ_CARBONO",
            allocationSize = 1
    )
    @Column(name = "REDUCAO_CARBONO_ID")
    private Long reducaoCarbonoId;

    private String descricao;

    private String categoria;

    private String status;

    @Column(name = "EMISSAO_BASE_TCO2E", precision = 15, scale = 2)
    private BigDecimal emissaoBaseTco2E;

    @Column(name = "META_REDUCAO_TCO2E", precision = 15, scale = 2)
    private BigDecimal metaReducaoTco2E;
}
