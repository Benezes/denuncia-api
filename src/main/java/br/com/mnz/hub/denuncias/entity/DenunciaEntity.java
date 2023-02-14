package br.com.mnz.hub.denuncias.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "tb_denuncia")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DenunciaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double latitude;
    private Double longitude;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "denunciante_id", referencedColumnName = "id")
    private DenuncianteEntity denunciante;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "denuncia_detalhe_id", referencedColumnName = "id")
    private DenunciaDetalheEntity denunciaDetalhe;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private EnderecoEntity endereco;

}
