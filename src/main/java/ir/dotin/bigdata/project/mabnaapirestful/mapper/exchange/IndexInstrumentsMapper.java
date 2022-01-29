package ir.dotin.bigdata.project.mabnaapirestful.mapper.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.broker.response.exchange.IndexInstrumentsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.IndexInstrumentsModel;

public class IndexInstrumentsMapper {
    public static IndexInstrumentsModel map(IndexInstrumentsResponse.IndexInstrumentsResponseInner instrumentsResponseInner){

        String indexId=null;
        String instrumentId=null;

        if(instrumentsResponseInner.getIndex()!=null)
            indexId=instrumentsResponseInner.getIndex().getId();

        if(instrumentsResponseInner.getInstrument()!=null)
            instrumentId=null;

        return new IndexInstrumentsModel(
                instrumentsResponseInner.getId(),
                indexId,
                instrumentId,
                MetaMapper.map(instrumentsResponseInner.getMetaResponse())
        );
    }
}
