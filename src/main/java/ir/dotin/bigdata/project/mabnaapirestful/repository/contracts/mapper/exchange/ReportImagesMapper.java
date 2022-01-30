package ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.ReportImagesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.ReportImagesModel;

public class ReportImagesMapper {
    public static ReportImagesModel map(ReportImagesResponse.ReportImagesResponseInner reportImagesResponseInner) {
        String reportId = null;


        if (reportImagesResponseInner.getReportsResponseInner() != null)
            reportId = reportImagesResponseInner.getReportsResponseInner().getId();


        return new ReportImagesModel(
                reportImagesResponseInner.getId(),
                reportId,
                reportImagesResponseInner.getContentType(),
                reportImagesResponseInner.getContentLength(),
                MetaMapper.map(reportImagesResponseInner.getMetaResponse())
        );
    }
}
