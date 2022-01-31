package ir.dotin.bigdata.project.mabnaapirestful.mapper;

import ir.dotin.bigdata.project.mabnaapirestful.api.response.FinancialViewTypeResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.FinancialViewTypeModel;

public class FinancialViewMapper {
    public static FinancialViewTypeModel map(FinancialViewTypeResponse financialViewTypeResponse){
        return new FinancialViewTypeModel(
                financialViewTypeResponse.getId(),
                financialViewTypeResponse.getTitle(),
                financialViewTypeResponse.getEnglishTitle(),
                financialViewTypeResponse.getMetaResponse().getType(),
                financialViewTypeResponse.getMetaResponse().getVersion(),
                financialViewTypeResponse.getMetaResponse().getState(),
                financialViewTypeResponse.getMetaResponse().getInsertDateTime(),
                financialViewTypeResponse.getMetaResponse().getUpdateDateTime(),
                financialViewTypeResponse.getMetaResponse().getDeleteDateTime()

        );
    }
}
