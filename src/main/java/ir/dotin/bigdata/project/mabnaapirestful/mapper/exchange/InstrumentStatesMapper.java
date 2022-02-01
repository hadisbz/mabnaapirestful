package ir.dotin.bigdata.project.mabnaapirestful.mapper.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.InstrumentStatesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.InstrumentStatesModel;

public class InstrumentStatesMapper {
    public static InstrumentStatesModel map(InstrumentStatesResponse.InstrumentStatesResponseInner instrumentStatesResponseInner){
        String instrumentId=null;
        String instrumentStateTypeId=null;
        String instrumentStateTypeMetaType=null;
        String instrumentStateStateId=null;
        String instrumentStateStateMetaType=null;

        if(instrumentStatesResponseInner.getInstrument()!=null)
            instrumentId=instrumentStatesResponseInner.getInstrument().getId();

        if(instrumentStatesResponseInner.getType()!=null){
            instrumentStateTypeId=instrumentStatesResponseInner.getType().getId();
            instrumentStateTypeMetaType=instrumentStatesResponseInner.getType().getMetaResponse().getType();
        }

        if(instrumentStatesResponseInner.getState()!=null) {
            instrumentStateStateId = instrumentStatesResponseInner.getState().getId();
            instrumentStateStateMetaType=instrumentStatesResponseInner.getState().getMetaResponse().getType();

        }

        return new InstrumentStatesModel(
                instrumentStatesResponseInner.getId(),
                instrumentId,
                instrumentStatesResponseInner.getDateTime(),
                instrumentStatesResponseInner.getDate(),
                instrumentStateTypeId,
                instrumentStateTypeMetaType,
                instrumentStateStateId,
                instrumentStateStateMetaType,
                MetaMapper.map(instrumentStatesResponseInner.getMetaResponse())
        );

    }
}
