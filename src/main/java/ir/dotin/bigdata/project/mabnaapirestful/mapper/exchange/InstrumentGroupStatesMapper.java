package ir.dotin.bigdata.project.mabnaapirestful.mapper.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.InstrumentGroupStatesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.InstrumentGroupStatesModel;

public class InstrumentGroupStatesMapper {
    public static InstrumentGroupStatesModel map(InstrumentGroupStatesResponse.InstrumentGroupStatesResponseInner instrumentGroupStatesResponseInner){
        String groupId=null;
        String typeId = null;

        if(instrumentGroupStatesResponseInner.getGroup()!=null)
            groupId=instrumentGroupStatesResponseInner.getGroup().getId();

        if(instrumentGroupStatesResponseInner.getType()!=null)
            typeId=instrumentGroupStatesResponseInner.getType().getId();

        return new InstrumentGroupStatesModel(
                instrumentGroupStatesResponseInner.getId(),
                groupId,
                typeId,
                instrumentGroupStatesResponseInner.getDateTime(),
                MetaMapper.map(instrumentGroupStatesResponseInner.getMetaResponse())
        );
    }
}
