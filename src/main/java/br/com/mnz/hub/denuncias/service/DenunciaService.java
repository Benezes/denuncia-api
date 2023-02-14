package br.com.mnz.hub.denuncias.service;

import br.com.mnz.hub.denuncias.dto.request.HubDenunciaRequest;
import br.com.mnz.hub.denuncias.dto.response.DenunciaResponse;
import br.com.mnz.hub.denuncias.dto.response.DenuncianteResponse;
import br.com.mnz.hub.denuncias.dto.response.EnderecoResponse;
import br.com.mnz.hub.denuncias.dto.response.HubDenunciaResponse;
import br.com.mnz.hub.denuncias.entity.DenunciaEntity;
import br.com.mnz.hub.denuncias.repository.DenunciaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DenunciaService {

    private final DenunciaBuilder denunciaBuilder;
    private final DenunciaRepository denunciaRepository;
    private final ExternalCall externalCall;

    public HubDenunciaResponse criarDenuncia(HubDenunciaRequest data) {

        DenunciaResponse denuncia = denunciaBuilder.buildDenunciaResponse(data);

        EnderecoResponse endereco = externalCall.recuperarEndereco(data.getLatitude(), data.getLongitude());

        DenuncianteResponse denunciante = denunciaBuilder.buildDenuncianteResponse(data);

        DenunciaEntity denunciaEntity = denunciaBuilder.buildDenunciaEntity(data, denuncia, endereco, denunciante);

        return denunciaBuilder.buildHubDenunciaResponse(denunciaRepository.save(denunciaEntity));
    }


}
