package ir.dotin.bigdata.project.mabnaapirestful.api.response.fund;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.MetaResponse;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
@Getter
@ToString
public class FundValuesResponse {
    @JsonProperty("data")
    private List<FundValuesResponseInner> data;

    @Getter
    @ToString
    public static class FundValuesResponseInner {
        private String id;

        private FundsResponse.FundsResponseInner fund;

        private String date;

        @JsonProperty("bid_price")
        private Long bidPrice;

        @JsonProperty("redemption_price")
        private Long redemptionPrice;

        @JsonProperty("statistical_price")
        private Long statisticalPrice;

        @JsonProperty("bid_count")
        private Long bidCount;

        @JsonProperty("redemption_count")
        private Long redemptionCount;

        private Long nav;

        private Long units;

        @JsonProperty("meta")
        private MetaResponse metaResponse;
    }

}

