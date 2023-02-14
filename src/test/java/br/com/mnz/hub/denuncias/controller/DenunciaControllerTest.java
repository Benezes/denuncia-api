package br.com.mnz.hub.denuncias.controller;

import br.com.mnz.hub.denuncias.dto.request.DenunciaRequest;
import br.com.mnz.hub.denuncias.dto.request.DenuncianteRequest;
import br.com.mnz.hub.denuncias.dto.request.HubDenunciaRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@DisplayName("DenunciaController")
class DenunciaControllerTest {

    private static final String CLIENTES = "http://localhost:8080/v1/denuncias";
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldCreateDenunciaSuccessfully() throws Exception {
        HubDenunciaRequest data = buildDenuncia();
        String jsonBody = objectMapper.writeValueAsString(data);

        ResultActions result = mockMvc.perform(post(CLIENTES).content(jsonBody).contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));

        result.andExpect(status().isCreated());
    }


    @Test
    void shouldNotCreateDenunciaSuccessfullyEnderecoNotFound() throws Exception {
        HubDenunciaRequest data = buildDenuncia();
        data.setLatitude(9999.9);
        data.setLongitude(9999.9);
        String jsonBody = objectMapper.writeValueAsString(data);

        ResultActions result = mockMvc.perform(post(CLIENTES).content(jsonBody).contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));

        result.andExpect(status().isNotFound());
    }

    private HubDenunciaRequest buildDenuncia() {
        return HubDenunciaRequest.builder()
                .latitude(-15.789925709252136)
                .longitude(-47.887251273393815)
                .denunciante(DenuncianteRequest.builder()
                        .nome("José da Silva")
                        .cpf("45616532145")
                        .build())
                .denuncia(DenunciaRequest.builder()
                        .titulo("Esgoto a céu aberto")
                        .descricao("Existe um esgoto a céu aberto nesta localidade.")
                        .build())
                .build();
    }
}