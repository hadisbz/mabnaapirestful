package ir.dotin.bigdata.project.mabnaapirestful.mapper;

import ir.dotin.bigdata.project.mabnaapirestful.api.response.MetaResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.MetaModel;

public class MetaMapper {
    public static MetaModel map(MetaResponse metaResponse){
        return new MetaModel(
               metaResponse.getType(),
                metaResponse.getVersion(),
                metaResponse.getState(),
                metaResponse.getInsertDateTime(),
                metaResponse.getInsertDateTime(),
                metaResponse.getDeleteDateTime()
        );
    }
}
