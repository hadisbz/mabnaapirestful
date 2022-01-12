package ir.dotin.bigdata.project.mabnaapirestful.mapper.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.InstrumentExchangeStatesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.InstrumentExchangeStatesModel;

public class InstrumentExchangeStatesMapper {
    public static InstrumentExchangeStatesModel map(InstrumentExchangeStatesResponse.InstrumentExchangeStatesResponseInner InstrumentExchangeStatesResponseInner){
        return new InstrumentExchangeStatesModel(
                null,
                InstrumentExchangeStatesResponseInner.getId(),
                InstrumentExchangeStatesResponseInner.getTitle(),
                InstrumentExchangeStatesResponseInner.getEnglishTitle(),
                MetaMapper.map(InstrumentExchangeStatesResponseInner.getMetaResponse())
        );
    }
}
