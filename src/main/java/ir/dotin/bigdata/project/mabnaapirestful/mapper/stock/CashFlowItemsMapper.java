package ir.dotin.bigdata.project.mabnaapirestful.mapper.stock;

import ir.dotin.bigdata.project.mabnaapirestful.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.broker.response.stock.CashFlowItemsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.stock.CashFlowItemsModel;

public class CashFlowItemsMapper {
    public static CashFlowItemsModel map(CashFlowItemsResponse.CashFlowItemsResponseInner cashFlowItemsResponseInner){
        String cashFlowId=null;
        String fieldId=null;

        if(cashFlowItemsResponseInner.getCashFlow()!=null)
            cashFlowId=cashFlowItemsResponseInner.getId();

        if(cashFlowItemsResponseInner.getField()!=null)
            fieldId=cashFlowItemsResponseInner.getId();

        return new CashFlowItemsModel(
                cashFlowItemsResponseInner.getId(),
                cashFlowId,
                fieldId,
                cashFlowItemsResponseInner.getValue(),
                MetaMapper.map(cashFlowItemsResponseInner.getMetaResponse())
        );
    }

}
