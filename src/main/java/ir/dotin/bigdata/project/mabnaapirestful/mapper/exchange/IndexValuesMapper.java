package ir.dotin.bigdata.project.mabnaapirestful.mapper.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.IndexValuesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.IndexValuesModel;

public class IndexValuesMapper {
    public static  IndexValuesModel map( IndexValuesResponse. IndexValuesResponseInner  indexValuesResponseInner) {
        String indexId = null;

        if ( indexValuesResponseInner.getIndex() != null)
            indexId =  indexValuesResponseInner.getIndex().getId();

        return new  IndexValuesModel(
                null,
                 indexValuesResponseInner.getId(),
                indexId,
                 indexValuesResponseInner.getDateTime(),
                 indexValuesResponseInner.getCloseValue(),
                 indexValuesResponseInner.getCloseValueChange(),
                 indexValuesResponseInner.getOpenValue(),
                 indexValuesResponseInner.getLowValue(),
                 indexValuesResponseInner.getHighValue(),
                MetaMapper.map( indexValuesResponseInner.getMetaResponse())
        );
    }

}
