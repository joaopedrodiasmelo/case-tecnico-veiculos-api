package com.joaopedro.mock_api_caseveiculos.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MolicarIndicadorMock {
    private String codigo;
    private String descricao;
}
