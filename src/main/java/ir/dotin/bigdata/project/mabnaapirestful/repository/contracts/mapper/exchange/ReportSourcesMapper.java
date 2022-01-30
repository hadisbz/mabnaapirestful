package ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.ReportSourcesResponse;
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
