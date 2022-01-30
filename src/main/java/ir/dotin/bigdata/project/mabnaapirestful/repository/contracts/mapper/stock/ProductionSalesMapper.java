package ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.stock;

import ir.dotin.bigdata.project.mabnaapirestful.api.response.stock.ProductionSalesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.AnnouncementTypeMapper;
import ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.AnnouncementTypeModel;
import ir.dotin.bigdata.project.mabnaapirestful.model.FinancialViewTypeModel;
import ir.dotin.bigdata.project.mabnaapirestful.model.stock.ProductionSalesModel;

public class ProductionSalesMapper {
    public static ProductionSalesModel map(ProductionSalesResponse.ProductionSalesResponseInner productionSalesResponseInner){
        String companyId = null;
        String meetingId= null;
        String reportId= null;
        AnnouncementTypeModel announcementTypeModel= null;
        FinancialViewTypeModel financialViewTypeModel = null;

        if(productionSalesResponseInner.getCompany()!=null)
            companyId=productionSalesResponseInner.getCompany().getId();

        if(productionSalesResponseInner.getReport()!=null)
            reportId=productionSalesResponseInner.getReport().getId();

        if(productionSalesResponseInner.getAnnouncementType()!=null){
            announcementTypeModel = AnnouncementTypeMapper.map(productionSalesResponseInner.getAnnouncementType());
        }

        return new ProductionSalesModel(
                productionSalesResponseInner.getId(),
                companyId,
                reportId,
                productionSalesResponseInner.getDate(),
                productionSalesResponseInner.getFiscalYear(),
                productionSalesResponseInner.getFiscalPeriod(),
                productionSalesResponseInner.getIsAudited(),
                productionSalesResponseInner.getIsCombined(),
                productionSalesResponseInner.getIsRepresented(),
                productionSalesResponseInner.getComments(),
                productionSalesResponseInner.getEnglishComments(),
                MetaMapper.map(productionSalesResponseInner.getMetaResponse()),
                announcementTypeModel
        );
    }
}
