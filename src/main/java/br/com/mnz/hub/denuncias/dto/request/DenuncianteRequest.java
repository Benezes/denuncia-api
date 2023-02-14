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
public class DenuncianteRequest {

    @NotEmpty
    private String nome;
    @NotEmpty
    private String cpf;
}
