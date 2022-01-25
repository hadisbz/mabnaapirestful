package ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.MetaResponse;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class TradesResponse {
    @JsonProperty("data")
    private List<TradesResponseInner> data;

    @Getter
    @ToString
    public static class TradesResponseInner {
        private String id;

        private InstrumentsResponse.InstrumentsResponseInner instrument;

        @JsonProperty("date_time")
        private String dateTime;

        @JsonProperty("open_price")
        private Double openPrice;

        @JsonProperty("high_price")
        private Double highPrice;

        @JsonProperty("low_price")
        private Double lowPrice;

        @JsonProperty("real_close_price")
        private Double realClosePrice;

        @JsonProperty("real_close_price_change")
        private Double realClosePriceChange;

        @JsonProperty("close_price")
        private Double closePrice;

        @JsonProperty("close_price_change")
        private Double closePriceChange;

        @JsonProperty("buyer_count")
        private Integer buyerCount;

        private Long volume;

        private Double value;

        @JsonProperty("trade_count")
        private Integer tradeCount;

        @JsonProperty("adjusted_close_price")
        private Double adjustedClosePrice;

        @JsonProperty("meta")
        private MetaResponse metaResponse;

    }
}
