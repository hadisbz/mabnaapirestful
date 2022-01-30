package ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.stock;

import ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.stock.ProfitLossItemsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.stock.ProfitLossItemsModel;

public class ProfitLossItemsMapper {
    public  static ProfitLossItemsModel map(ProfitLossItemsResponse.ProfitLossItemsResponseInner profitLossItemsResponseInner){
        String profitLossId=null;
        String fieldId=null;

        if(profitLossItemsResponseInner.getProfitLoss()!=null)
            profitLossId=profitLossItemsResponseInner.getProfitLoss().getId();

        if(profitLossItemsResponseInner.getField()!=null)
            fieldId = profitLossItemsResponseInner.getField().getId();

        return new ProfitLossItemsModel(
                profitLossItemsResponseInner.getId(),
                profitLossId,
                fieldId,
                profitLossItemsResponseInner.getValue(),
                MetaMapper.map((profitLossItemsResponseInner.getMetaResponse()))

        );
    }
}
