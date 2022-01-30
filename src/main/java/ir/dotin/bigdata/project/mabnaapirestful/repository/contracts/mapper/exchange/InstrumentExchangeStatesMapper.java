package ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.InstrumentExchangeStatesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.InstrumentExchangeStatesModel;

public class InstrumentExchangeStatesMapper {
    public static InstrumentExchangeStatesModel map(InstrumentExchangeStatesResponse.InstrumentExchangeStatesResponseInner InstrumentExchangeStatesResponseInner){
        return new InstrumentExchangeStatesModel(
                InstrumentExchangeStatesResponseInner.getId(),
                InstrumentExchangeStatesResponseInner.getTitle(),
                InstrumentExchangeStatesResponseInner.getEnglishTitle(),
                MetaMapper.map(InstrumentExchangeStatesResponseInner.getMetaResponse())
        );
    }
}
