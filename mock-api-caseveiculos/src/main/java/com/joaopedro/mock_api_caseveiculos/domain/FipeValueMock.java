package com.joaopedro.mock_api_caseveiculos.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class FipeValueMock {
    private double valorFIPE;
    private String dataConsulta;
    private String nomenclaturaFIPE;
    private double indiceComparacao;
    private boolean desvalorizacao;
}
