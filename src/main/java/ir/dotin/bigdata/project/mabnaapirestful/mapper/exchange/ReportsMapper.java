package ir.dotin.bigdata.project.mabnaapirestful.mapper.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.ReportsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.ReportImagesModel;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.ReportSubTitlesModel;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.ReportsModel;

import java.util.List;
import java.util.stream.Collectors;

public class ReportsMapper {
    public static ReportsModel map(ReportsResponse.ReportsResponseInner reportsResponse) {
        String sourceId = null;
        String titleId = null;
        String entityId = null;
        String entityType = null;
        List<ReportSubTitlesModel> reportSubTitlesModelList=null;
        List<ReportImagesModel> reportImagesModels =  null;
        String companyId=null;

        if(reportsResponse.getSource()!=null)
            sourceId = reportsResponse.getSource().getId();

        if(reportsResponse.getTitle()!=null)
            titleId = reportsResponse.getTitle().getId();

        if(reportsResponse.getStock()!=null)
            if(reportsResponse.getStock().getCompany()!=null)
                companyId=reportsResponse.getStock().getCompany().getId();

        if (reportsResponse.getEntity() != null) {
            entityId = reportsResponse.getEntity().getId();
            entityType = reportsResponse.getEntity().getMetaResponse().getType();
        }

        if(reportsResponse.getSubtitles() != null)
            reportSubTitlesModelList = reportsResponse.getSubtitles().stream().map(ReportSubTitlesMapper::map).collect(Collectors.toList());


        if(reportsResponse.getImages()!=null)
            reportImagesModels=reportsResponse.getImages().stream().map(ReportImagesMapper::map).collect(Collectors.toList());

        return new ReportsModel(
                reportsResponse.getId(),
                reportsResponse.getDate(),
                reportsResponse.getNumber(),
                sourceId,
                titleId,
                reportsResponse.getFiscalYear(),
                reportSubTitlesModelList,
                companyId,
                entityId,
                entityType,
                reportImagesModels,
                MetaMapper.map(reportsResponse.getMetaResponse())
        );
    }
}
