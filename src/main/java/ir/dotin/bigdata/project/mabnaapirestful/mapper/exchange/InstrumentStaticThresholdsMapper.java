package ir.dotin.bigdata.project.mabnaapirestful.mapper.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.InstrumentStaticThresholdsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.InstrumentStaticThresholdsModel;

public class InstrumentStaticThresholdsMapper {
    public static InstrumentStaticThresholdsModel map(InstrumentStaticThresholdsResponse.InstrumentStaticThresholdsResponseInner instrumentStaticThresholdsResponseInner){
        String instrumentId=null;

        if(instrumentStaticThresholdsResponseInner.getInstrument()!=null)
            instrumentId=instrumentStaticThresholdsResponseInner.getInstrument().getId();

        return new InstrumentStaticThresholdsModel(
                instrumentStaticThresholdsResponseInner.getId(),
                instrumentId,
                instrumentStaticThresholdsResponseInner.getDateTime(),
                instrumentStaticThresholdsResponseInner.getMinPricePermit(),
                instrumentStaticThresholdsResponseInner.getMaxPricePermit(),
                MetaMapper.map(instrumentStaticThresholdsResponseInner.getMetaResponse())
        );
    }
}
