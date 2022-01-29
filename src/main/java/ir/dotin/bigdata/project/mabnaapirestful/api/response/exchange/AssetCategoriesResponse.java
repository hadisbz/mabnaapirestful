package ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.MetaResponse;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class AssetCategoriesResponse {
    @JsonProperty("data")
    private List<AssetCategoriesResponseInner> data;

    @Getter
    @ToString
    public static class  AssetCategoriesResponseInner {
        private String id;

        private AssetsResponse.AssetsResponseInner asset;

        private CategoriesResponse.CategoriesResponseInner category;

        @JsonProperty("meta")
        private MetaResponse metaResponse;
    }

}
