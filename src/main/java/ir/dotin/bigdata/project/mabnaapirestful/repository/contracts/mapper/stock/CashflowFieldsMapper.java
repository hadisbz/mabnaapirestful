package ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.stock;

import ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.stock.CashflowFieldsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.stock.CashflowFieldsModel;

public class CashflowFieldsMapper {
    public static CashflowFieldsModel map(CashflowFieldsResponse.CashflowFieldsResponseInner cashflowFieldsResponseInner){
        return new CashflowFieldsModel(
                cashflowFieldsResponseInner.getId(),
                cashflowFieldsResponseInner.getTitle(),
                cashflowFieldsResponseInner.getEnglishTitle(),
                cashflowFieldsResponseInner.getAccount(),
                cashflowFieldsResponseInner.getIndex(),
                MetaMapper.map(cashflowFieldsResponseInner.getMetaResponse())
        );
    }
}
