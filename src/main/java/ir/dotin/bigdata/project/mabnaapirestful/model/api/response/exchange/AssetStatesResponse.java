package ir.dotin.bigdata.project.mabnaapirestful.model.api.response.exchange;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.model.api.response.MetaResponse;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString

public class AssetStatesResponse {
    @JsonProperty("data")
    private List<AssetStatesResponse.AssetStatesResponseInner> data;

    @Getter
    @ToString
    public static class AssetStatesResponseInner {
        private String id;

        private String title;

        @JsonProperty("english_title")
        private String englishTitle;

        @JsonProperty("meta")
        private MetaResponse metaResponse;
    }
}
