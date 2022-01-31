package ir.dotin.bigdata.project.mabnaapirestful.mapper.stock;

import ir.dotin.bigdata.project.mabnaapirestful.api.response.stock.UnitsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.stock.UnitsModel;

public class UnitsMapper {
    public static UnitsModel map(UnitsResponse.UnitsResponseInner unitsResponseInner){
        String baseId=null;
        String baseType=null;

        if(unitsResponseInner.getBase()!=null){
            baseId=unitsResponseInner.getBase().getId();
            baseType=unitsResponseInner.getBase().getMetaResponse().getType();
        }
        return new UnitsModel(
                unitsResponseInner.getId(),
                unitsResponseInner.getTitle(),
                unitsResponseInner.getEnglishTitle(),
                unitsResponseInner.getFactor(),
                baseId,
                baseType,
                MetaMapper.map(unitsResponseInner.getMetaResponse())
        );
    }
}
