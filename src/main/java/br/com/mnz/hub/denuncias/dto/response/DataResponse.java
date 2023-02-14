package br.com.mnz.hub.denuncias.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DataResponse {

    private Long id;
    private Double latitude;
    private Double longitude;
    private DenuncianteResponse denunciante;
    private DenunciaResponse denuncia;
    private EnderecoResponse endereco;
}
