package ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.MetaResponse;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class AssetTypesResponse {
    @JsonProperty("data")
    private List<AssetTypesResponseInner> data;

    @Getter
    @ToString
    public static class AssetTypesResponseInner {
        private String id;

        private String title;

        @JsonProperty("english_title")
        private String englishTitle;

        private String code;

        @JsonProperty("meta")
        private MetaResponse metaResponse;
    }

}
