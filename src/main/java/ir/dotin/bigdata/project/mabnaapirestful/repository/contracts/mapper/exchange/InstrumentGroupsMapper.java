package ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.InstrumentGroupsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.InstrumentGroupsModel;

public class InstrumentGroupsMapper {
    public static InstrumentGroupsModel map(InstrumentGroupsResponse.InstrumentGroupsResponseInner instrumentGroupsResponseInner) {
        return new InstrumentGroupsModel(
                instrumentGroupsResponseInner.getId(),
                instrumentGroupsResponseInner.getCode(),
                instrumentGroupsResponseInner.getTitle(),
                instrumentGroupsResponseInner.getEnglishTitle(),
                MetaMapper.map(instrumentGroupsResponseInner.getMetaResponse())
        );
    }
}
