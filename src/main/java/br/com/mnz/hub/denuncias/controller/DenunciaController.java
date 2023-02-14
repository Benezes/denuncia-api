package br.com.mnz.hub.denuncias.controller;

import br.com.mnz.hub.denuncias.dto.request.HubDenunciaRequest;
import br.com.mnz.hub.denuncias.dto.response.HubDenunciaResponse;
import br.com.mnz.hub.denuncias.service.DenunciaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/denuncias")
@AllArgsConstructor
public class DenunciaController {

    private final DenunciaService denunciaService;

    @PostMapping
    public ResponseEntity<HubDenunciaResponse> criarDenuncia(@RequestBody @Valid HubDenunciaRequest data) {
        return ResponseEntity.status(HttpStatus.CREATED).body((denunciaService.criarDenuncia(data)));
    }
}
