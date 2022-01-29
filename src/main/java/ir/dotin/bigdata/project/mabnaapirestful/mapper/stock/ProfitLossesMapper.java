package ir.dotin.bigdata.project.mabnaapirestful.mapper.stock;

import ir.dotin.bigdata.project.mabnaapirestful.api.response.stock.ProfitLossesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.AnnouncementTypeMapper;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.FinancialViewMapper;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.AnnouncementTypeModel;
import ir.dotin.bigdata.project.mabnaapirestful.model.FinancialViewTypeModel;
import ir.dotin.bigdata.project.mabnaapirestful.model.stock.ProfitLossesModel;

public class ProfitLossesMapper {
    public static ProfitLossesModel map(ProfitLossesResponse.ProfitLossesResponseInner profitLossesResponseInner){
        String companyId = null;
        String meetingId= null;
        String reportId= null;
        AnnouncementTypeModel announcementTypeModel= null;
        FinancialViewTypeModel financialViewModel = null;

        if(profitLossesResponseInner.getCompany()!=null)
            companyId=profitLossesResponseInner.getCompany().getId();

        if(profitLossesResponseInner.getMeeting()!=null)
            meetingId=profitLossesResponseInner.getMeeting().getId();

        if(profitLossesResponseInner.getReport()!=null)
            reportId=profitLossesResponseInner.getReport().getId();

        if(profitLossesResponseInner.getAnnouncementType()!=null){
            announcementTypeModel = AnnouncementTypeMapper.map(profitLossesResponseInner.getAnnouncementType());
        }

        if(profitLossesResponseInner.getFinancialViewType()!=null){
            financialViewModel = FinancialViewMapper.map(profitLossesResponseInner.getFinancialViewType());
        }

        return new ProfitLossesModel(
                profitLossesResponseInner.getId(),
                companyId,
                meetingId,
                reportId,
                profitLossesResponseInner.getDate(),
                profitLossesResponseInner.getFiscalYear(),
                profitLossesResponseInner.getFiscalPeriod(),
                profitLossesResponseInner.getIsAudited(),
                profitLossesResponseInner.getIsCombined(),
                profitLossesResponseInner.getIsRepresented(),
                profitLossesResponseInner.getCapital(),
                profitLossesResponseInner.getComments(),
                profitLossesResponseInner.getEnglishComments(),
                MetaMapper.map(profitLossesResponseInner.getMetaResponse()),
                announcementTypeModel,
                financialViewModel
        );
    }
}
