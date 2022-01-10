package ir.dotin.bigdata.project.mabnaapirestful.mapper.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.InstrumentGroupsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.PercentageActionTypesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.InstrumentGroupsModel;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.PercentageActionTypesModel;

public class InstrumentGroupsMapper {
    public static InstrumentGroupsModel map(InstrumentGroupsResponse.InstrumentGroupsResponseInner instrumentGroupsResponseInner) {
        return new InstrumentGroupsModel(
                null,
                instrumentGroupsResponseInner.getId(),
                instrumentGroupsResponseInner.getCode(),
                instrumentGroupsResponseInner.getTitle(),
                instrumentGroupsResponseInner.getEnglishTitle(),
                MetaMapper.map(instrumentGroupsResponseInner.getMetaResponse())
        );
    }
}
