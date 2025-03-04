package com.joaopedro.mock_api_caseveiculos.domain;

import lombok.*;
import java.util.List;

@Getter
@Setter
@Builder(toBuilder = true)
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class VeiculoMock {

        @EqualsAndHashCode.Include
        private String codigo;
        private String mensagem;
        @EqualsAndHashCode.Include
        private String placa;
        private String chassi;
        private String ufJurisdicao;
        private String nomeMunicipioEmplacamento;
        private int anoFabricacao;
        private int anoModelo;
        private String marca;
        private String modelo;
        private String tipoVeiculo;
        private String tipoCarroceria;
        private String numeroCarroceria;
        private String corPredominante;
        private String combustivel;
        private int potencia;
        private int cilindradas;
        private int capacidadePassageiros;
        private String numeroCaixaCambio;
        private int numeroEixos;
        private String numeroMotor;
        private String dataEmplacamento;
        private int quantidadeAquisicoes;
        private String dataUltimaAquisicao;
        private String ufUltimaAquisicao;
        private String ufAtual;
        private String nomeMunicipioUltimaAquisicao;
        private List<FipeIndicadorMock> indicadoresFipe;
        private List<MolicarIndicadorMock> indicadoresMolicar;
        private List<IcarrosIndicadorMock> indicadoresIcarros;
}
