package com.joaopedro.mock_api_caseveiculos.service;

import com.joaopedro.mock_api_caseveiculos.domain.FipeIndicadorMock;
import com.joaopedro.mock_api_caseveiculos.domain.VeiculoMock;
import com.joaopedro.mock_api_caseveiculos.repository.VeiculoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VeiculoService {
    private final VeiculoRepository veiculoRepository;

    public List<VeiculoMock> findAll() {
        return veiculoRepository.findAll();
    }

    public VeiculoMock findByPlacaOrThrowNotFound(String placa) {
        return veiculoRepository.findByPlaca(placa)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Placa não encontrada"));
    }

    public VeiculoMock findByPlacaAndMesORThrowNotFound(String placa, int mes){
        VeiculoMock veiculoMock1 = findByPlacaOrThrowNotFound(placa);

        VeiculoMock veiculoMock2 = veiculoMock1.toBuilder()
                .indicadoresFipe(veiculoMock1.getIndicadoresFipe().stream()
                        .map(fipe -> FipeIndicadorMock.builder()
                                .codigoFIPE(fipe.getCodigoFIPE())
                                .valores(fipe.getValores().stream()
                                        .limit(Math.min(mes, fipe.getValores().size()))
                                        .collect(Collectors.toList()))
                                .build())
                        .collect(Collectors.toList()))
                .indicadoresIcarros(veiculoMock1.getIndicadoresIcarros().stream()
                        .limit(Math.min(mes, veiculoMock1.getIndicadoresIcarros().size()))
                        .collect(Collectors.toList()))
                .build();

        return veiculoMock2;
    }
}
