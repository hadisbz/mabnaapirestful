package ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.ReportSubTitlesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.ReportSubTitlesModel;

public class ReportSubTitlesMapper {
    public static ReportSubTitlesModel map(ReportSubTitlesResponse.ReportSubTitlesResponseInner ReportSubTitlesResponseInner){
        return new ReportSubTitlesModel(
                ReportSubTitlesResponseInner.getId(),
                ReportSubTitlesResponseInner.getTitle(),
                ReportSubTitlesResponseInner.getEnglishTitle(),
                MetaMapper.map(ReportSubTitlesResponseInner.getMetaResponse())
        );
    }
}
