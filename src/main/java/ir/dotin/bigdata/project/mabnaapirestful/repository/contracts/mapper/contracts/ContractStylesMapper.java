package ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.contracts;

import ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.contracts.ContractStylesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.contracts.ContractStylesModel;

public class ContractStylesMapper {
    public static ContractStylesModel map(ContractStylesResponse.ContractStylesResponseInner ContractStylesResponseInner){
        return new ContractStylesModel(
                ContractStylesResponseInner.getId(),
                ContractStylesResponseInner.getTitle(),
                ContractStylesResponseInner.getEnglishTitle(),
                MetaMapper.map(ContractStylesResponseInner.getMetaResponse())
        );
    }

}
