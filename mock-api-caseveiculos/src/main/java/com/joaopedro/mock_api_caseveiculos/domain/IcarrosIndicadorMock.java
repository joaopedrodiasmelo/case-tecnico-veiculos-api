    package com.joaopedro.mock_api_caseveiculos.domain;


    import lombok.Builder;
    import lombok.Getter;
    import lombok.Setter;

    @Getter
    @Setter
    @Builder
    public class IcarrosIndicadorMock {
        private String codigoICARROS;
        private double valorICARROS;
        private String mesConsulta;
        private String nomenclaturaICARROS;
        private double indiceComparacao;
        private boolean desvalorizacao;
    }
