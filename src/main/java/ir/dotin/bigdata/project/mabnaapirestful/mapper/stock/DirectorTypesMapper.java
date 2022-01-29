package ir.dotin.bigdata.project.mabnaapirestful.mapper.stock;

import ir.dotin.bigdata.project.mabnaapirestful.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.broker.response.stock.DirectorTypesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.stock.DirectorTypesModel;

public class DirectorTypesMapper {
    public static DirectorTypesModel map(DirectorTypesResponse.DirectorTypesResponseInner DirectorTypesResponseInner){
        return new DirectorTypesModel(
                DirectorTypesResponseInner.getId(),
                DirectorTypesResponseInner.getTitle(),
                DirectorTypesResponseInner.getEnglishTitle(),
                MetaMapper.map(DirectorTypesResponseInner.getMetaResponse())
        );
    }
}
