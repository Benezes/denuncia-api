package br.com.mnz.hub.denuncias.service;

import br.com.mnz.hub.denuncias.dto.response.EnderecoResponse;
import br.com.mnz.hub.denuncias.service.exception.EnderecoNotFoundException;
import br.com.mnz.hub.denuncias.service.exception.InvalidJsonException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
@AllArgsConstructor
public class ExternalCall {

    private static final String API_KEY = "Ag0CzRcOdGbFelLETTan7kbwzyZzNjFs";
    private static final String MAPQUEST_API_URL = "http://www.mapquestapi.com/geocoding/v1/reverse?key=" + API_KEY + "&location={latitude},{longitude}&includeRoadMetadata=true&includeNearestIntersection=true";
    public static final String EXPECTED_STATUS_CODE = "0";
    private final RestTemplate restTemplate;
    private final ObjectMapper mapper;
    private final DenunciaBuilder denunciaBuilder;

    @Cacheable(value = "endereco", key = "{#latitude, #longitude}")
    public EnderecoResponse recuperarEndereco(double latitude, double longitude) {
        ResponseEntity<String> response = restTemplate.exchange(MAPQUEST_API_URL, HttpMethod.GET, null, String.class, latitude, longitude);

        try {
            int statusCode = mapper.readTree(response.getBody()).get("info").get("statuscode").asInt();

            if (!Integer.toString(statusCode).equals(EXPECTED_STATUS_CODE))
                throw new EnderecoNotFoundException("Endereço não encontrado para essa localidade.");

        } catch (JsonProcessingException e) {
            throw new InvalidJsonException("Request inválido.");
        }


        return processaJson(response);
    }

    private EnderecoResponse processaJson(ResponseEntity<String> response) {
        try {
            JsonNode rootNode = mapper.readTree(response.getBody());
            JsonNode locationsNode = rootNode.get("results").get(0).get("locations");
            String logradouro = locationsNode.get(0).get("street").asText();
            String bairro = locationsNode.get(0).get("adminArea6").asText();
            String cidade = locationsNode.get(0).get("adminArea5").asText();
            String estado = locationsNode.get(0).get("adminArea3").asText();
            String pais = locationsNode.get(0).get("adminArea1").asText();
            String cep = locationsNode.get(0).get("postalCode").asText();

            return denunciaBuilder.buildEndereco(logradouro, bairro, cidade, estado, pais, cep);
        } catch (JsonProcessingException e) {
            throw new InvalidJsonException("Request inválido.");
        }
    }

}
