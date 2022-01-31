package ir.dotin.bigdata.project.mabnaapirestful.mapper.stock;

import ir.dotin.bigdata.project.mabnaapirestful.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.stock.BalancesheetFieldsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.stock.BalancesheetFieldsModel;

public class BalancesheetFieldsMapper {
    public static BalancesheetFieldsModel map(BalancesheetFieldsResponse.BalancesheetFieldsResponseInner balancesheetFieldsResponseInner){
        return new BalancesheetFieldsModel(
                balancesheetFieldsResponseInner.getId(),
                balancesheetFieldsResponseInner.getTitle(),
                balancesheetFieldsResponseInner.getEnglishTitle(),
                balancesheetFieldsResponseInner.getAccount(),
                balancesheetFieldsResponseInner.getIndex(),
                MetaMapper.map(balancesheetFieldsResponseInner.getMetaResponse())
        );
    }
}
