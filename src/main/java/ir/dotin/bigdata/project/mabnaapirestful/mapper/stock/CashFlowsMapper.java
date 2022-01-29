package ir.dotin.bigdata.project.mabnaapirestful.mapper.stock;

import ir.dotin.bigdata.project.mabnaapirestful.api.response.stock.CashFlowsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.AnnouncementTypeMapper;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.FinancialViewMapper;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.AnnouncementTypeModel;
import ir.dotin.bigdata.project.mabnaapirestful.model.FinancialViewTypeModel;
import ir.dotin.bigdata.project.mabnaapirestful.model.stock.CashFlowsModel;

public class CashFlowsMapper {
    public static CashFlowsModel map(CashFlowsResponse.CashFlowsResponseInner cashFlowsResponseInner){
        String companyId = null;
        String meetingId= null;
        String reportId= null;
        AnnouncementTypeModel announcementTypeModel= null;
        FinancialViewTypeModel financialViewTypeModel = null;

        if(cashFlowsResponseInner.getCompany()!=null)
            companyId=cashFlowsResponseInner.getCompany().getId();

        if(cashFlowsResponseInner.getMeeting()!=null)
            meetingId=cashFlowsResponseInner.getMeeting().getId();

        if(cashFlowsResponseInner.getReport()!=null)
            reportId=cashFlowsResponseInner.getReport().getId();

        if(cashFlowsResponseInner.getAnnouncementType()!=null){
            announcementTypeModel = AnnouncementTypeMapper.map(cashFlowsResponseInner.getAnnouncementType());
        }

        if(cashFlowsResponseInner.getFinancialViewType()!=null){
            financialViewTypeModel = FinancialViewMapper.map(cashFlowsResponseInner.getFinancialViewType());
        }
        return new CashFlowsModel(
                cashFlowsResponseInner.getId(),
                companyId,
                meetingId,
                reportId,
                cashFlowsResponseInner.getDate(),
                cashFlowsResponseInner.getFiscalYear(),
                cashFlowsResponseInner.getFiscalPeriod(),
                cashFlowsResponseInner.getIsAudited(),
                cashFlowsResponseInner.getIsCombined(),
                cashFlowsResponseInner.getIsRepresented(),
                cashFlowsResponseInner.getComments(),
                cashFlowsResponseInner.getEnglishComments(),
                MetaMapper.map(cashFlowsResponseInner.getMetaResponse()),
                announcementTypeModel,
                financialViewTypeModel
        );
    }
}
