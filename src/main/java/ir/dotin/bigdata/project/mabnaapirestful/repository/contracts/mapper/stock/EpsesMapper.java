package ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.stock;

import ir.dotin.bigdata.project.mabnaapirestful.api.response.stock.EpsesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.stock.EpsesModel;

public class EpsesMapper {
    public static EpsesModel map(EpsesResponse.EpsesResponseInner epsesResponseInner){
        String companyId = null;
        String meetingId= null;
        String reportId= null;

        if(epsesResponseInner.getCompany()!=null)
            companyId=epsesResponseInner.getCompany().getId();

        if(epsesResponseInner.getMeeting()!=null)
            meetingId=epsesResponseInner.getMeeting().getId();

        if(epsesResponseInner.getReport()!=null)
            reportId=epsesResponseInner.getReport().getId();


        return new EpsesModel(
                epsesResponseInner.getId(),
                companyId,
                meetingId,
                reportId,
                epsesResponseInner.getAnnouncementType(),
                epsesResponseInner.getDate(),
                epsesResponseInner.getFiscalYear(),
                epsesResponseInner.getFiscalPeriod(),
                epsesResponseInner.getIsAudited(),
                epsesResponseInner.getIsCombined(),
                epsesResponseInner.getIsRepresented(),
                epsesResponseInner.getCapital(),
                epsesResponseInner.getImpureRealizedEps(),
                epsesResponseInner.getPureRealizedEps(),
                epsesResponseInner.getImpureDps(),
                epsesResponseInner.getPureDps(),
                epsesResponseInner.getImpureForecastEps(),
                epsesResponseInner.getPureForecastEps(),
                MetaMapper.map(epsesResponseInner.getMetaResponse())
        );
    }

}
