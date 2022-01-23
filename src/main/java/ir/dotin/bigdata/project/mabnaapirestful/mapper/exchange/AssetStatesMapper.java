package ir.dotin.bigdata.project.mabnaapirestful.mapper.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.model.api.response.exchange.AssetStatesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.AssetStatesModel;

public class AssetStatesMapper {
    public static AssetStatesModel map(AssetStatesResponse.AssetStatesResponseInner AssetStatesResponseInner) {
        return new AssetStatesModel(
                null,
                AssetStatesResponseInner.getId(),
                AssetStatesResponseInner.getTitle(),
                AssetStatesResponseInner.getEnglishTitle(),
                MetaMapper.map(AssetStatesResponseInner.getMetaResponse())
        );
    }
}
