package ir.dotin.bigdata.project.mabnaapirestful.mapper.stock;

import ir.dotin.bigdata.project.mabnaapirestful.model.broker.response.stock.BalancesheetsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.AnnouncementTypeMapper;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.FinancialViewMapper;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.AnnouncementTypeModel;
import ir.dotin.bigdata.project.mabnaapirestful.model.FinancialViewTypeModel;
import ir.dotin.bigdata.project.mabnaapirestful.model.stock.BalancesheetsModel;

public class BalancesheetsMapper {
    public static BalancesheetsModel map(BalancesheetsResponse.BalancesheetsResponseInner balancesheetsResponseInner){
        String companyId = null;
        String meetingId= null;
        String reportId= null;
        AnnouncementTypeModel announcementTypeModel= null;
        FinancialViewTypeModel financialViewTypeModel = null;

        if(balancesheetsResponseInner.getCompany()!=null)
            companyId=balancesheetsResponseInner.getCompany().getId();

        if(balancesheetsResponseInner.getMeeting()!=null)
            meetingId=balancesheetsResponseInner.getMeeting().getId();

        if(balancesheetsResponseInner.getReport()!=null)
            reportId=balancesheetsResponseInner.getReport().getId();

        if(balancesheetsResponseInner.getAnnouncementType()!=null){
            announcementTypeModel = AnnouncementTypeMapper.map(balancesheetsResponseInner.getAnnouncementType());
        }

        if(balancesheetsResponseInner.getFinancialViewType()!=null){
            financialViewTypeModel = FinancialViewMapper.map(balancesheetsResponseInner.getFinancialViewType());
        }
        return new BalancesheetsModel(
                balancesheetsResponseInner.getId(),
                companyId,
                meetingId,
                reportId,
                balancesheetsResponseInner.getDate(),
                balancesheetsResponseInner.getFiscalYear(),
                balancesheetsResponseInner.getFiscalPeriod(),
                balancesheetsResponseInner.getIsAudited(),
                balancesheetsResponseInner.getIsCombined(),
                balancesheetsResponseInner.getIsRepresented(),
                balancesheetsResponseInner.getComments(),
                balancesheetsResponseInner.getEnglishComments(),
                MetaMapper.map(balancesheetsResponseInner.getMetaResponse()),
                announcementTypeModel,
                financialViewTypeModel
        );
    }
}
