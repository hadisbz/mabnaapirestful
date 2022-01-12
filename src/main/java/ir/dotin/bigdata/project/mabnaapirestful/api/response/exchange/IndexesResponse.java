package ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.MetaResponse;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
@Getter
@ToString
public class IndexesResponse {
    @JsonProperty("data")
    private List<IndexesResponse.IndexesResponseInner> data;

    @Getter
    @ToString
    public static class IndexesResponseInner {
        private String id;

        private String code;

        private String name;

        @JsonProperty("english_name")
        private String englishName;

        @JsonProperty("short_name")
        private String shortName;

        @JsonProperty("english_short_name")
        private String englishShortName;

        @JsonProperty("fingilish_name")
        private String fingilishName;

        @JsonProperty("fingilish_short_name")
        private String fingilishShortName;

        @JsonProperty("meta")
        private MetaResponse metaResponse;
    }
}
