package ir.dotin.bigdata.project.mabnaapirestful.mapper.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.broker.response.exchange.GenderTypesResponse;
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
