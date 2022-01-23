package ir.dotin.bigdata.project.mabnaapirestful.mapper.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.model.api.response.exchange.InstrumentGroupStateTypesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.InstrumentGroupStateTypesModel;

public class InstrumentGroupStateTypesMapper {
    public static InstrumentGroupStateTypesModel map(InstrumentGroupStateTypesResponse.InstrumentGroupStateTypesResponseInner InstrumentGroupStateTypesResponseInner){
        return new InstrumentGroupStateTypesModel(
                null,
                InstrumentGroupStateTypesResponseInner.getId(),
                InstrumentGroupStateTypesResponseInner.getTitle(),
                InstrumentGroupStateTypesResponseInner.getEnglishTitle(),
                MetaMapper.map(InstrumentGroupStateTypesResponseInner.getMetaResponse())
        );
    }
}
