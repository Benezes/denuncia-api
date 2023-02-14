package br.com.mnz.hub.denuncias.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DenunciaRequest {

    @NotEmpty
    private String titulo;
    @NotEmpty
    private String descricao;
}
