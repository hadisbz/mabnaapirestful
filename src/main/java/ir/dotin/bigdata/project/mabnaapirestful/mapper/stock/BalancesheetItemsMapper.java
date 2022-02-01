package ir.dotin.bigdata.project.mabnaapirestful.mapper.stock;

import ir.dotin.bigdata.project.mabnaapirestful.api.response.stock.BalancesheetItemsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.stock.BalancesheetItemsModel;

public class BalancesheetItemsMapper {
    public static BalancesheetItemsModel map(BalancesheetItemsResponse.BalancesheetItemsResponseInner balancesheetItemsResponseInner){
        String balanceSheetId=null;
        String fieldId=null;

        if(balancesheetItemsResponseInner.getBalanceSheet()!=null)
            balanceSheetId=balancesheetItemsResponseInner.getBalanceSheet().getId();

        if(balancesheetItemsResponseInner.getField()!=null)
            fieldId=balancesheetItemsResponseInner.getField().getId();

        return new BalancesheetItemsModel(
                balancesheetItemsResponseInner.getId(),
                balanceSheetId,
                fieldId,
                balancesheetItemsResponseInner.getValue(),
                MetaMapper.map(balancesheetItemsResponseInner.getMetaResponse())
        );
    }
}
