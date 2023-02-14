package br.com.mnz.hub.denuncias.dto.response;

import br.com.mnz.hub.denuncias.entity.DenunciaEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HubDenunciaResponse {

    private DataResponse data;

}
