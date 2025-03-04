package com.joaopedro.mock_api_caseveiculos.repository;

import com.joaopedro.mock_api_caseveiculos.domain.VeiculoMock;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class VeiculoRepository {
    private  final VeiculoData veiculoData;

    public List<VeiculoMock> findAll() {
        return veiculoData.getVeiculosMocks();
    }

    public Optional<VeiculoMock> findByPlaca(String placa) {
        return veiculoData.getVeiculosMocks().stream().filter(veiculoMock -> veiculoMock.getPlaca().equals(placa)).findFirst();
    }

}
