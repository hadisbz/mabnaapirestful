package ir.dotin.bigdata.project.mabnaapirestful.api.response.stock;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.MetaResponse;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class BalancesheetFieldsResponse {
    @JsonProperty("data")
    private List<BalancesheetFieldsResponseInner> data;

    @Getter
    @ToString
    public static class BalancesheetFieldsResponseInner {
        private String id;

        private String title;

        @JsonProperty("english_title")
        private String englishTitle;

        private String account;

        private Long index;

        @JsonProperty("meta")
        private MetaResponse metaResponse;
    }

}
