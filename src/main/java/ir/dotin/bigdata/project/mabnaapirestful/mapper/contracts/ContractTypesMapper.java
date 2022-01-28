package ir.dotin.bigdata.project.mabnaapirestful.mapper.contracts;

import ir.dotin.bigdata.project.mabnaapirestful.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.contracts.ContractTypesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.contracts.ContractTypesModel;


public class ContractTypesMapper {
    public static ContractTypesModel map(ContractTypesResponse.ContractTypesResponseInner ContractTypesResponseInner) {
        return new ContractTypesModel(
                null,
                ContractTypesResponseInner.getId(),
                ContractTypesResponseInner.getTitle(),
                ContractTypesResponseInner.getEnglishTitle(),
                MetaMapper.map(ContractTypesResponseInner.getMetaResponse()));
    }
}
