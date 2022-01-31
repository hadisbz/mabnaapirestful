package ir.dotin.bigdata.project.mabnaapirestful.mapper.stock;

import ir.dotin.bigdata.project.mabnaapirestful.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.stock.ProfitlossFieldsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.stock.ProfitlossFieldsModel;

public class ProfitlossFieldsMapper {
    public static ProfitlossFieldsModel map(ProfitlossFieldsResponse.ProfitlossFieldsResponseInner profitlossFieldsResponseInner){
        return new ProfitlossFieldsModel(
                profitlossFieldsResponseInner.getId(),
                profitlossFieldsResponseInner.getTitle(),
                profitlossFieldsResponseInner.getEnglishTitle(),
                profitlossFieldsResponseInner.getAccount(),
                profitlossFieldsResponseInner.getIndex(),
                MetaMapper.map(profitlossFieldsResponseInner.getMetaResponse())
        );
    }
}
