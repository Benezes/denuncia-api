package br.com.mnz.hub.denuncias.service;

import br.com.mnz.hub.denuncias.dto.request.HubDenunciaRequest;
import br.com.mnz.hub.denuncias.dto.response.*;
import br.com.mnz.hub.denuncias.entity.DenunciaDetalheEntity;
import br.com.mnz.hub.denuncias.entity.DenunciaEntity;
import br.com.mnz.hub.denuncias.entity.DenuncianteEntity;
import br.com.mnz.hub.denuncias.entity.EnderecoEntity;
import org.springframework.stereotype.Component;

@Component
public class DenunciaBuilder {

    public HubDenunciaResponse buildHubDenunciaResponse(DenunciaEntity denunciaEntity) {
        return HubDenunciaResponse.builder()
                .data(DataResponse.builder() //
                        .id(denunciaEntity.getId()) //
                        .latitude(denunciaEntity.getLatitude()) //
                        .longitude(denunciaEntity.getLongitude()) //
                        .denunciante(DenuncianteResponse.builder() //
                                .nome(denunciaEntity.getDenunciante().getNome()) //
                                .cpf(denunciaEntity.getDenunciante().getCpf()) //
                                .build()) //
                        .denuncia(DenunciaResponse.builder() //
                                .titulo(denunciaEntity.getDenunciaDetalhe().getTitulo()) //
                                .descricao(denunciaEntity.getDenunciaDetalhe().getDescricao()) //
                                .build()) //
                        .endereco(EnderecoResponse.builder() //
                                .logradouro(denunciaEntity.getEndereco().getLogradouro()) //
                                .bairro(denunciaEntity.getEndereco().getBairro()) //
                                .cidade(denunciaEntity.getEndereco().getCidade()) //
                                .estado(denunciaEntity.getEndereco().getEstado()) //
                                .pais(denunciaEntity.getEndereco().getPais()) //
                                .cep(denunciaEntity.getEndereco().getCep()) //
                                .build()) //
                        .build()) //
                .build();
    }

    public DenunciaEntity buildDenunciaEntity(HubDenunciaRequest data, DenunciaResponse denuncia, EnderecoResponse endereco, DenuncianteResponse denunciante) {
        return DenunciaEntity
                .builder() //
                .latitude(data.getLatitude()) //
                .longitude(data.getLongitude()) //
                .denunciante(DenuncianteEntity.builder() //
                        .nome(denunciante.getNome()) //
                        .cpf(denunciante.getCpf()) //
                        .build()) //
                .denunciaDetalhe(DenunciaDetalheEntity.builder() //
                        .titulo(denuncia.getTitulo()) //
                        .descricao(denuncia.getDescricao()) //
                        .build()) //
                .endereco(EnderecoEntity.builder() //
                        .logradouro(endereco.getLogradouro()) //
                        .bairro(endereco.getBairro()) //
                        .cidade(endereco.getCidade()) //
                        .estado(endereco.getEstado()) //
                        .pais(endereco.getPais()) //
                        .cep(endereco.getCep()) //
                        .build()) //
                .build();
    }

    public DenuncianteResponse buildDenuncianteResponse(HubDenunciaRequest data) {
        return DenuncianteResponse
                .builder() //
                .nome(data.getDenunciante().getNome()) //
                .cpf(data.getDenunciante().getCpf()) //
                .build();
    }

    public DenunciaResponse buildDenunciaResponse(HubDenunciaRequest data) {
        return DenunciaResponse
                .builder() //
                .titulo(data.getDenuncia().getTitulo()) //
                .descricao(data.getDenuncia().getDescricao()) //
                .build();
    }

    public EnderecoResponse buildEndereco(String logradouro, String bairro, String cidade, String estado, String pais, String cep) {
        return EnderecoResponse
                .builder() //
                .logradouro(logradouro) //
                .bairro(bairro) //
                .cidade(cidade) //
                .estado(estado) //
                .pais(pais) //
                .cep(cep) //
                .build();
    }
}
