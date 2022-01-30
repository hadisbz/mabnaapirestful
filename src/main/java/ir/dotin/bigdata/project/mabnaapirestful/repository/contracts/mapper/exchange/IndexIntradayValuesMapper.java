package ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.IndexIntradayValuesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.IndexIntradayValuesModel;

public class IndexIntradayValuesMapper {
    public static  IndexIntradayValuesModel map( IndexIntradayValuesResponse. IndexIntradayValuesResponseInner  indexIntradayValuesResponseInner) {
        String indexId = null;
        String indexValuesId = null;
        if(indexIntradayValuesResponseInner.getIndexValue() != null)
            indexValuesId = indexIntradayValuesResponseInner.getIndexValue().getId();

        if ( indexIntradayValuesResponseInner.getIndex() != null)
            indexId =  indexIntradayValuesResponseInner.getIndex().getId();

        return new  IndexIntradayValuesModel(
                indexIntradayValuesResponseInner.getId(),
                indexValuesId,
                indexId,
                indexIntradayValuesResponseInner.getDateTime(),
                indexIntradayValuesResponseInner.getCloseValue(),
                MetaMapper.map( indexIntradayValuesResponseInner.getMetaResponse())
        );
    }
}
