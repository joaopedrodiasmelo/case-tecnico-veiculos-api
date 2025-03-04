package com.joaopedro.mock_api_caseveiculos.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@Builder
public class FipeIndicadorMock {
    private String codigoFIPE;
    private List<FipeValueMock> valores;
}
