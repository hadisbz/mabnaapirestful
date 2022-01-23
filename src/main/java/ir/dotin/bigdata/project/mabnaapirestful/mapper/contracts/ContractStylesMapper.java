package ir.dotin.bigdata.project.mabnaapirestful.mapper.contracts;

import ir.dotin.bigdata.project.mabnaapirestful.model.api.response.contracts.ContractStylesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.contracts.ContractStylesModel;

public class ContractStylesMapper {
    public static ContractStylesModel map(ContractStylesResponse.ContractStylesResponseInner ContractStylesResponseInner){
        return new ContractStylesModel(
                null,
                ContractStylesResponseInner.getId(),
                ContractStylesResponseInner.getTitle(),
                ContractStylesResponseInner.getEnglishTitle(),
                MetaMapper.map(ContractStylesResponseInner.getMetaResponse())
        );
    }

}
