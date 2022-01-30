package ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.GenderTypesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.GenderTypesModel;

public class GenderTypesMapper {
    public static GenderTypesModel map(GenderTypesResponse.GenderTypesResponseInner GenderTypesResponseInner){
        return new GenderTypesModel(
                GenderTypesResponseInner.getId(),
                GenderTypesResponseInner.getTitle(),
                GenderTypesResponseInner.getEnglishTitle(),
                MetaMapper.map(GenderTypesResponseInner.getMetaResponse())
        );
    }

}
