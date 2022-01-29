package ir.dotin.bigdata.project.mabnaapirestful.model.broker.response.exchange;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.model.broker.response.MetaResponse;
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
        private Long orderRank;

        @JsonProperty("ask_count")
        private Long askCount;

        @JsonProperty("ask_order")
        private Long askOrder;

        @JsonProperty("ask_volume")
        private Long askVolume;

        @JsonProperty("ask_price")
        private Double askPrice;

        @JsonProperty("bid_order")
        private Long bidOrder;

        @JsonProperty("bid_volume")
        private Long bidVolume;

        @JsonProperty("bid_price")
        private Double bidPrice;

        @JsonProperty("meta")
        private MetaResponse metaResponse;
    }
}
