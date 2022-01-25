package ir.dotin.bigdata.project.mabnaapirestful.mapper.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.InstrumentBaseVolumesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.InstrumentBaseVolumesModel;

public class InstrumentBaseVolumesMapper {
    public static InstrumentBaseVolumesModel map(InstrumentBaseVolumesResponse.InstrumentBaseVolumesResponseInner instrumentBaseVolumesResponseInner){
        String instrumentId=null;

        if(instrumentBaseVolumesResponseInner.getInstrument()!=null)
            instrumentId=instrumentBaseVolumesResponseInner.getInstrument().getId();

        return new InstrumentBaseVolumesModel(
                null,
                instrumentBaseVolumesResponseInner.getId(),
                instrumentId,
                instrumentBaseVolumesResponseInner.getDateTime(),
                instrumentBaseVolumesResponseInner.getBaseVolume(),
                MetaMapper.map(instrumentBaseVolumesResponseInner.getMetaResponse())
        );
    }
}
