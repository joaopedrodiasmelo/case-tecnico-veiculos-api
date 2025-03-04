package com.joaopedro.mock_api_caseveiculos.mapper;

import com.joaopedro.mock_api_caseveiculos.domain.VeiculoMock;
import com.joaopedro.mock_api_caseveiculos.response.VeiculoGetResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface VeiculoMapper {

    VeiculoGetResponse toVeiculoGetResponse(VeiculoMock veiculoMock);

    List<VeiculoGetResponse> toVeiculoGetResponseList(List<VeiculoMock> veiculoMocks);
}
