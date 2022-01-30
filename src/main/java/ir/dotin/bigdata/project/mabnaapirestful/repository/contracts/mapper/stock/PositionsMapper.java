package ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.stock;

import ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.stock.PositionsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.stock.PositionsModel;

public class PositionsMapper {
    public static PositionsModel map(PositionsResponse.PositionsResponseInner PositionsResponseInner){
        return new PositionsModel(
                PositionsResponseInner.getId(),
                PositionsResponseInner.getTitle(),
                PositionsResponseInner.getEnglishTitle(),
                MetaMapper.map(PositionsResponseInner.getMetaResponse())
        );
    }
    
}
