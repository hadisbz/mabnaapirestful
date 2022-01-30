package ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.IndexInstrumentEffectsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.IndexInstrumentEffectsModel;

public class IndexInstrumentEffectsMapper {
    public static IndexInstrumentEffectsModel map(IndexInstrumentEffectsResponse.IndexInstrumentEffectsResponseInner indexInstrumentEffectsResponseInner){
        String instrumentId=null;
        String indexId=null;

        if(indexInstrumentEffectsResponseInner.getInstrument()!=null)
            instrumentId=indexInstrumentEffectsResponseInner.getInstrument().getId();

        if(indexInstrumentEffectsResponseInner.getIndex()!=null)
            indexId=indexInstrumentEffectsResponseInner.getIndex().getId();

        return new IndexInstrumentEffectsModel(
                indexInstrumentEffectsResponseInner.getId(),
                instrumentId,
                indexId,
                indexInstrumentEffectsResponseInner.getDateTime(),
                indexInstrumentEffectsResponseInner.getEffect(),
                MetaMapper.map((indexInstrumentEffectsResponseInner.getMetaResponse()))
        );
    }
}
