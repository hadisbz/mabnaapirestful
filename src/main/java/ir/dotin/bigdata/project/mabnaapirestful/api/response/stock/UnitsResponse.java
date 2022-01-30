package ir.dotin.bigdata.project.mabnaapirestful.api.response.stock;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.BaseResponse;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.MetaResponse;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class UnitsResponse {
    @JsonProperty("data")
    private List<UnitsResponseInner> data;

    @Getter
    @ToString
    public static class UnitsResponseInner {
        private String id;

        private String title;

        @JsonProperty("english_title")
        private String englishTitle;

        private String factor;

        private BaseResponse base;

        @JsonProperty("meta")
        private MetaResponse metaResponse;
    }
}
