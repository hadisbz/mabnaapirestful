package ir.dotin.bigdata.project.mabnaapirestful.mapper.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.ReportTitlesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.ReportTitlesModel;

public class ReportTitlesMapper {
    public static ReportTitlesModel map(ReportTitlesResponse.ReportTitlesResponseInner ReportTitlesResponseInner){
        return new ReportTitlesModel(
                ReportTitlesResponseInner.getId(),
                ReportTitlesResponseInner.getTitle(),
                ReportTitlesResponseInner.getEnglishTitle(),
                MetaMapper.map(ReportTitlesResponseInner.getMetaResponse())
        );
    }
}
