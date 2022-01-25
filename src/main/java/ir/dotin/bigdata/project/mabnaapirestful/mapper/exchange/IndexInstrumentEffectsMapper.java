package ir.dotin.bigdata.project.mabnaapirestful.mapper.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.IndexInstrumentEffectsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.MetaMapper;
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
                null,
                indexInstrumentEffectsResponseInner.getId(),
                instrumentId,
                indexId,
                indexInstrumentEffectsResponseInner.getDateTime(),
                indexInstrumentEffectsResponseInner.getEffect(),
                MetaMapper.map((indexInstrumentEffectsResponseInner.getMetaResponse()))
        );
    }
}
