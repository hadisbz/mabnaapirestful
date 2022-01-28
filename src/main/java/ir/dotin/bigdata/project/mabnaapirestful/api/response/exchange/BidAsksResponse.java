package ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.MetaResponse;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class BidAsksResponse {
    @JsonProperty("data")
    private List<BidAsksResponseInner> data;

    @Getter
    @ToString
    public static class BidAsksResponseInner {
        private String id;

        private InstrumentsResponse.InstrumentsResponseInner instrument;

        @JsonProperty("date_time")
        private String dateTime;

        @JsonProperty("order_rank")
        private Integer orderRank;

        @JsonProperty("ask_count")
        private Integer askCount;

        @JsonProperty("ask_order")
        private Integer askOrder;

        @JsonProperty("ask_volume")
        private Integer askVolume;

        @JsonProperty("ask_price")
        private Double askPrice;

        @JsonProperty("bid_order")
        private Integer bidOrder;

        @JsonProperty("bid_volume")
        private Integer bidVolume;

        @JsonProperty("bid_price")
        private Double bidPrice;

        @JsonProperty("meta")
        private MetaResponse metaResponse;
    }
}
