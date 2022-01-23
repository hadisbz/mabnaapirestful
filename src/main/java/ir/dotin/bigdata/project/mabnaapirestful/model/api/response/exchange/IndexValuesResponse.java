package ir.dotin.bigdata.project.mabnaapirestful.model.api.response.exchange;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.model.api.response.MetaResponse;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
@Getter
@ToString
public class IndexValuesResponse {
    @JsonProperty("data")
    private List<IndexValuesResponseInner> data;

    @Getter
    @ToString
    public static class IndexValuesResponseInner {
        private String id;

        @JsonProperty("index")
        private IndexesResponse.IndexesResponseInner index;

        @JsonProperty("date_time")
        private String dateTime;

        @JsonProperty("close_value")
        private Double closeValue;

        @JsonProperty("close_value_change")
        private Double closeValueChange;

        @JsonProperty("open_value")
        private Double openValue;

        @JsonProperty("low_value")
        private Double lowValue;

        @JsonProperty("high_value")
        private Double highValue;

        @JsonProperty("meta")
        private MetaResponse metaResponse;
    }
}
