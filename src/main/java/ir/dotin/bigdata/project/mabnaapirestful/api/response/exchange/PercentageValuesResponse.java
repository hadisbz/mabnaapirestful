package ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.MetaResponse;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class PercentageValuesResponse {
    @JsonProperty("data")
    private List<PercentageValuesResponseInner> data;

    @Getter
    @ToString
    public static class PercentageValuesResponseInner {
        private String id;

        @JsonProperty("percentage_group")
        private PercentageGroupsResponse.PercentageGroupsResponseInner percentageGroup;

        private PercentagesResponse.PercentagesResponseInner percentage;

        private Double value;

        private Double min;

        private Double max;

        @JsonProperty("meta")
        private MetaResponse metaResponse;
    }
}
