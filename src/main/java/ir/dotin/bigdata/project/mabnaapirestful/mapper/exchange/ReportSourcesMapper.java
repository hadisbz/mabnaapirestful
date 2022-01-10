package ir.dotin.bigdata.project.mabnaapirestful.mapper.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.ReportSourcesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.SourcesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.ReportSourcesModel;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.SourcesModel;

public class ReportSourcesMapper {
    public static ReportSourcesModel map(ReportSourcesResponse.ReportSourcesResponseInner reportSourcesResponseInner) {
        return new ReportSourcesModel(
                null,
                reportSourcesResponseInner.getId(),
                reportSourcesResponseInner.getTitle(),
                MetaMapper.map(reportSourcesResponseInner.getMetaResponse())
        );
    }
}
