package ir.dotin.bigdata.project.mabnaapirestful.api.response.stock;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.MetaResponse;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class ProfitlossFieldsResponse {
    @JsonProperty("data")
    private List<ProfitlossFieldsResponseInner> data;

    @Getter
    @ToString
    public static class ProfitlossFieldsResponseInner {
        private String id;

        private String title;

        @JsonProperty("english_title")
        private String englishTitle;

        private String account;

        private Integer index;

        @JsonProperty("meta")
        private MetaResponse metaResponse;
    }
}
