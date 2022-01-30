package ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.AssetStatesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.AssetStatesModel;

public class AssetStatesMapper {
    public static AssetStatesModel map(AssetStatesResponse.AssetStatesResponseInner AssetStatesResponseInner) {
        return new AssetStatesModel(
                AssetStatesResponseInner.getId(),
                AssetStatesResponseInner.getTitle(),
                AssetStatesResponseInner.getEnglishTitle(),
                MetaMapper.map(AssetStatesResponseInner.getMetaResponse())
        );
    }
}
