package br.com.mnz.hub.denuncias.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "tb_denuncia_detalhe")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DenunciaDetalheEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descricao;

}
