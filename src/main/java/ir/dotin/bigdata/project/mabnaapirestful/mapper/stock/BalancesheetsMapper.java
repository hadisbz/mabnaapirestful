package ir.dotin.bigdata.project.mabnaapirestful.mapper.stock;

import ir.dotin.bigdata.project.mabnaapirestful.api.response.stock.BalancesheetsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.stock.BalancesheetsModel;

public class BalancesheetsMapper {
    public static BalancesheetsModel map(BalancesheetsResponse.BalancesheetsResponseInner balancesheetsResponseInner){
        String companyId = null;
        String meetingId= null;
        String reportId= null;
        String announcementTypeID= null;
        String announcementTypeTitle= null;
        String announcementTypeEnglishTitle= null;
        String announcementTypeMetaType= null;
        String financialViewTypeID= null;
        String financialViewTypeTitle= null;
        String financialViewTypeEnglishTitle= null;
        String financialViewTypeMetaType= null;

        if(balancesheetsResponseInner.getCompany()!=null)
            companyId=balancesheetsResponseInner.getCompany().getId();

        if(balancesheetsResponseInner.getMeeting()!=null)
            meetingId=balancesheetsResponseInner.getMeeting().getId();

        if(balancesheetsResponseInner.getReport()!=null)
            reportId=balancesheetsResponseInner.getReport().getId();

        if(balancesheetsResponseInner.getAnnouncementType()!=null){
            announcementTypeID=balancesheetsResponseInner.getAnnouncementType().getId();
            announcementTypeTitle=balancesheetsResponseInner.getAnnouncementType().getTitle();
            announcementTypeEnglishTitle=balancesheetsResponseInner.getAnnouncementType().getEnglishTitle();
            announcementTypeMetaType= balancesheetsResponseInner.getAnnouncementType().getMetaResponse().getType();

        }

        if(balancesheetsResponseInner.getFinancialViewType()!=null){
            financialViewTypeID=balancesheetsResponseInner.getFinancialViewType().getId();
            financialViewTypeTitle=balancesheetsResponseInner.getFinancialViewType().getTitle();
            financialViewTypeEnglishTitle=balancesheetsResponseInner.getFinancialViewType().getEnglishTitle();
            financialViewTypeMetaType=balancesheetsResponseInner.getFinancialViewType().getMetaResponse().getType();

        }

        return new BalancesheetsModel(
                balancesheetsResponseInner.getId(),
                companyId,
                meetingId,
                reportId,
                announcementTypeID,
                announcementTypeTitle,
                announcementTypeEnglishTitle,
                announcementTypeMetaType,
                financialViewTypeID,
                financialViewTypeTitle,
                financialViewTypeEnglishTitle,
                financialViewTypeMetaType,
                balancesheetsResponseInner.getDate(),
                balancesheetsResponseInner.getFiscalYear(),
                balancesheetsResponseInner.getFiscalPeriod(),
                balancesheetsResponseInner.getIsAudited(),
                balancesheetsResponseInner.getIsCombined(),
                balancesheetsResponseInner.getIsRepresented(),
                balancesheetsResponseInner.getComments(),
                balancesheetsResponseInner.getEnglishComments(),
                MetaMapper.map(balancesheetsResponseInner.getMetaResponse())
        );
    }
}
