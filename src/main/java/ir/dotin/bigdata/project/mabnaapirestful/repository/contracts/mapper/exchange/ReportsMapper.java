package ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.ReportsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.ReportsModel;

public class ReportsMapper {
    public static ReportsModel map(ReportsResponse.ReportsResponseInner reportsResponse) {
        String sourceId = null;
        String titleId = null;
        String entityId = null;
        String entityType = null;

        if(reportsResponse.getSource()!=null)
            sourceId = reportsResponse.getSource().getId();

        if(reportsResponse.getTitle()!=null)
            titleId = reportsResponse.getTitle().getId();

        if (reportsResponse.getEntity() != null) {
            entityId = reportsResponse.getEntity().getId();
            entityType = reportsResponse.getEntity().getMetaResponse().getType();
        }

        return new ReportsModel(
                reportsResponse.getId(),
                reportsResponse.getDate(),
                reportsResponse.getNumber(),
                sourceId,
                titleId,
                reportsResponse.getFiscalYear(),
                null,
                entityId,
                entityType,
                null,
                MetaMapper.map(reportsResponse.getMetaResponse())
        );
    }
}
