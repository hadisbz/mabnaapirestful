package ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.stock;

import ir.dotin.bigdata.project.mabnaapirestful.api.response.stock.CapitalChangesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.stock.CapitalChangesModel;

public class CapitalChangesMapper {
    public static CapitalChangesModel map(CapitalChangesResponse.CapitalChangesResponseInner capitalChangesResponseInner){
        String companyId=null;
        String reportId=null;
        String meetingId=null;
        String underwritingEndReportId=null;
        String registrationReportId=null;
        String stockCertificateReceiveReportId=null;

        if(capitalChangesResponseInner.getCompany()!=null)
            companyId=capitalChangesResponseInner.getCompany().getId();

        if(capitalChangesResponseInner.getReport()!=null)
            reportId=capitalChangesResponseInner.getReport().getId();

        if(capitalChangesResponseInner.getMeeting()!=null)
            meetingId=capitalChangesResponseInner.getMeeting().getId();

        if(capitalChangesResponseInner.getUnderwritingEndReport()!=null)
        underwritingEndReportId=capitalChangesResponseInner.getUnderwritingEndReport().getId();

        if(capitalChangesResponseInner.getRegistrationReport()!=null)
            registrationReportId=capitalChangesResponseInner.getRegistrationReport().getId();

        if(capitalChangesResponseInner.getStockCertificateReceiveReport()!=null)
            stockCertificateReceiveReportId = capitalChangesResponseInner.getStockCertificateReceiveReport().getId();

        return new CapitalChangesModel(
                capitalChangesResponseInner.getId(),
                companyId,
                reportId,
                capitalChangesResponseInner.getDate(),
                meetingId,
                capitalChangesResponseInner.getPreviousCapital(),
                capitalChangesResponseInner.getNewCapital(),
                capitalChangesResponseInner.getContributionPercent(),
                capitalChangesResponseInner.getReservePercent(),
                capitalChangesResponseInner.getPremiumPercent(),
                underwritingEndReportId,
                capitalChangesResponseInner.getUnderwritingEndDate(),
                registrationReportId,
                capitalChangesResponseInner.getRegistrationDate(),
                stockCertificateReceiveReportId,
                capitalChangesResponseInner.getStockCertificateReceiveDate(),
                capitalChangesResponseInner.getWarrantSellDate(),
                capitalChangesResponseInner.getComments(),
                capitalChangesResponseInner.getEnglishComments(),
                MetaMapper.map(capitalChangesResponseInner.getMetaResponse())
        );

    }
}
