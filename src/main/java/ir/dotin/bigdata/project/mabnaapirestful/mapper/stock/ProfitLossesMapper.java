///*
//package ir.dotin.bigdata.project.mabnaapirestful.mapper.stock;
//
//import ir.dotin.bigdata.project.mabnaapirestful.api.response.stock.ProfitLossesResponse;
//import ir.dotin.bigdata.project.mabnaapirestful.mapper.MetaMapper;
//import ir.dotin.bigdata.project.mabnaapirestful.model.stock.ProfitLossesModel;
//
//public class ProfitLossesMapper {
//    public static ProfitLossesModel map(ProfitLossesResponse.ProfitLossesResponseInner profitLossesResponseInner){
//        String companyId = null;
//        String meetingId= null;
//        String reportId= null;
//        String announcementTypeID= null;
//        String announcementTypeTitle= null;
//        String announcementTypeEnglishTitle= null;
//        String announcementTypeMetaType= null;
//        String financialViewTypeID= null;
//        String financialViewTypeTitle= null;
//        String financialViewTypeEnglishTitle= null;
//        String financialViewTypeMetaType= null;
//
//        if(profitLossesResponseInner.getCompany()!=null)
//            companyId=profitLossesResponseInner.getCompany().getId();
//
//        if(profitLossesResponseInner.getMeeting()!=null)
//            meetingId=profitLossesResponseInner.getMeeting().getId();
//
//        if(profitLossesResponseInner.getReport()!=null)
//            reportId=profitLossesResponseInner.getReport().getId();
//
//        if(profitLossesResponseInner.getAnnouncementType()!=null){
//            announcementTypeID=profitLossesResponseInner.getAnnouncementType().getId();
//            announcementTypeTitle=profitLossesResponseInner.getAnnouncementType().getTitle();
//            announcementTypeEnglishTitle=profitLossesResponseInner.getAnnouncementType().getEnglishTitle();
//            announcementTypeMetaType= profitLossesResponseInner.getAnnouncementType().getMetaResponse().getType();
//
//        }
//
//        if(profitLossesResponseInner.getFinancialViewType()!=null){
//            financialViewTypeID=profitLossesResponseInner.getFinancialViewType().getId();
//            financialViewTypeTitle=profitLossesResponseInner.getFinancialViewType().getTitle();
//            financialViewTypeEnglishTitle=profitLossesResponseInner.getFinancialViewType().getEnglishTitle();
//            financialViewTypeMetaType=profitLossesResponseInner.getFinancialViewType().getMetaResponse().getType();
//
//        }
//
//        return new ProfitLossesModel(
//                profitLossesResponseInner.getId(),
//                companyId,
//                meetingId,
//                reportId,
//                announcementTypeID,
//                announcementTypeTitle,
//                announcementTypeEnglishTitle,
//                announcementTypeMetaType,
//                financialViewTypeID,
//                financialViewTypeTitle,
//                financialViewTypeEnglishTitle,
//                financialViewTypeMetaType,
//                profitLossesResponseInner.getDate(),
//                profitLossesResponseInner.getFiscalYear(),
//                profitLossesResponseInner.getFiscalPeriod(),
//                profitLossesResponseInner.getIsAudited(),
//                profitLossesResponseInner.getIsCombined(),
//                profitLossesResponseInner.getIsRepresented(),
//                profitLossesResponseInner.getCapital(),
//                profitLossesResponseInner.getComments(),
//                profitLossesResponseInner.getEnglishComments(),
//                MetaMapper.map(profitLossesResponseInner.getMetaResponse())
//        );
//
//    }
//
//}
//*/
