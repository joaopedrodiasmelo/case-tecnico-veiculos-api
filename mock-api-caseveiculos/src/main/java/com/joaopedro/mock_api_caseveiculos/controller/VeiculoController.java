package com.joaopedro.mock_api_caseveiculos.controller;

import com.joaopedro.mock_api_caseveiculos.mapper.VeiculoMapper;
import com.joaopedro.mock_api_caseveiculos.response.VeiculoGetResponse;
import com.joaopedro.mock_api_caseveiculos.service.VeiculoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/placa")
@Slf4j
@RequiredArgsConstructor
public class VeiculoController {
    private final VeiculoService veiculoService;
    private final VeiculoMapper mapper;
    private static final String API_KEY = "chave-api";

    @GetMapping(headers = "api-veiculo-mock")
    public ResponseEntity<List<VeiculoGetResponse>> findAll(
            @RequestHeader("api-veiculo-mock") String apiKey) {
        log.debug("Requisição para listar todos os veículos e suas informações");


        if (!API_KEY.equals(apiKey)) {
            return ResponseEntity.status(401).build(); //chave inválida
        }

        var veiculos = veiculoService.findAll();
        var veiculoGetResponse = mapper.toVeiculoGetResponseList(veiculos);

        return ResponseEntity.ok(veiculoGetResponse);
    }

    @GetMapping(value = "{placa}/", headers = "api-veiculo-mock")
    public ResponseEntity<VeiculoGetResponse> findByPlaca(
            @PathVariable String placa,
            @RequestHeader("api-veiculo-mock") String apiKey) {
        log.debug("Requisição para listar o veículo e suas informações");


        if (!API_KEY.equals(apiKey)) {
            return ResponseEntity.status(401).build(); // chave inválida
        }

        var veiculo = veiculoService.findByPlacaOrThrowNotFound(placa);
        var veiculoGetResponse = mapper.toVeiculoGetResponse(veiculo);

        return ResponseEntity.ok(veiculoGetResponse);
    }


    @GetMapping(value = "{placa}", headers = "api-veiculo-mock")
    public ResponseEntity<VeiculoGetResponse> findByPlacaAndMes(
            @PathVariable String placa,
            @RequestParam int mes,
            @RequestHeader("api-veiculo-mock") String apiKey) {
        log.debug("Requisição para listar o veículo e suas informações atrelados ao parâmetro mes");

        if (!API_KEY.equals(apiKey)) {
            return ResponseEntity.status(401).build(); // chave inválida
        }

        var veiculo = veiculoService.findByPlacaAndMesORThrowNotFound(placa, mes);
        var veiculoGetResponse = mapper.toVeiculoGetResponse(veiculo);

        return ResponseEntity.ok(veiculoGetResponse);
    }
}