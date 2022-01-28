package ir.dotin.bigdata.project.mabnaapirestful.mapper;

import ir.dotin.bigdata.project.mabnaapirestful.api.response.AnnouncementTypeResponse;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.FinancialViewTypeResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.AnnouncementTypeModel;
import ir.dotin.bigdata.project.mabnaapirestful.model.FinancialViewModel;

public class FinancialViewMapper {
    public static FinancialViewModel map(FinancialViewTypeResponse financialViewTypeResponse){
        return new FinancialViewModel(
                financialViewTypeResponse.getId(),
                financialViewTypeResponse.getTitle(),
                financialViewTypeResponse.getEnglishTitle(),
                financialViewTypeResponse.getMetaResponse().getType()
        );
    }
}
