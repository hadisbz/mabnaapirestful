package ir.dotin.bigdata.project.mabnaapirestful.mapper.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.model.api.response.exchange.IndexesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.IndexesModel;

public class IndexesMapper {
    public static IndexesModel map(IndexesResponse.IndexesResponseInner IndexesResponseInner){
        return new IndexesModel(
                null,
                IndexesResponseInner.getId(),
                IndexesResponseInner.getCode(),
                IndexesResponseInner.getName(),
                IndexesResponseInner.getEnglishName(),
                IndexesResponseInner.getShortName(),
                IndexesResponseInner.getEnglishShortName(),
                IndexesResponseInner.getFingilishName(),
                IndexesResponseInner.getFingilishShortName(),
                MetaMapper.map(IndexesResponseInner.getMetaResponse())
        );
    }
}
