package ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.MetaResponse;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class IndexIntradayTradeSummariesResponse {
    @JsonProperty("data")
    private List<IndexIntradayTradeSummariesResponseInner> data;

    @Getter
    @ToString
    public static class IndexIntradayTradeSummariesResponseInner {
        private String id;

        @JsonProperty("index")
        private IndexesResponse.IndexesResponseInner index;

        @JsonProperty("date_time")
        private String dateTime;

        private Double value;

        private long volume;

        @JsonProperty("trade_count")
        private Long tradeCount;

        @JsonProperty("buyer_count")
        private Long buyerCount;

        @JsonProperty("advance_trade_count")
        private Long advanceTradeCount;

        @JsonProperty("decline_trade_count")
        private Long declineTradeCount;

        @JsonProperty("meta")
        private MetaResponse metaResponse;
    }

}
