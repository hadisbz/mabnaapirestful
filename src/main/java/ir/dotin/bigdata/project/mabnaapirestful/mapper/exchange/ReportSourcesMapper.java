package ir.dotin.bigdata.project.mabnaapirestful.mapper.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.broker.response.exchange.ReportSourcesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.ReportSourcesModel;

public class ReportSourcesMapper {
    public static ReportSourcesModel map(ReportSourcesResponse.ReportSourcesResponseInner reportSourcesResponseInner) {
        return new ReportSourcesModel(
                reportSourcesResponseInner.getId(),
                reportSourcesResponseInner.getTitle(),
                MetaMapper.map(reportSourcesResponseInner.getMetaResponse())
        );
    }
}
