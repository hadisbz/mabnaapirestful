package ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.InstrumentGroupStateTypesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.InstrumentGroupStateTypesModel;

public class InstrumentGroupStateTypesMapper {
    public static InstrumentGroupStateTypesModel map(InstrumentGroupStateTypesResponse.InstrumentGroupStateTypesResponseInner InstrumentGroupStateTypesResponseInner){
        return new InstrumentGroupStateTypesModel(
                InstrumentGroupStateTypesResponseInner.getId(),
                InstrumentGroupStateTypesResponseInner.getTitle(),
                InstrumentGroupStateTypesResponseInner.getEnglishTitle(),
                MetaMapper.map(InstrumentGroupStateTypesResponseInner.getMetaResponse())
        );
    }
}
