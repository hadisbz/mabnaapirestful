package ir.dotin.bigdata.project.mabnaapirestful.model.broker.response.exchange;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.model.broker.response.MetaResponse;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
@Getter
@ToString
public class IndexIntradayValuesResponse {
    @JsonProperty("data")
    private List<IndexIntradayValuesResponseInner> data;

    @Getter
    @ToString
    public static class IndexIntradayValuesResponseInner {
        private String id;

        @JsonProperty("index_value")
        private IndexValuesResponse.IndexValuesResponseInner indexValue;

        @JsonProperty("index")
        private IndexesResponse.IndexesResponseInner index;

        @JsonProperty("date_time")
        private String dateTime;

        @JsonProperty("close_value")
        private Double closeValue;

        @JsonProperty("meta")
        private MetaResponse metaResponse;
    }
}
