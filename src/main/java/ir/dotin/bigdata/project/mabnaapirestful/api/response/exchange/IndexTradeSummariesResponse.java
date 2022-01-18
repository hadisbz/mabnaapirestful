package ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.MetaResponse;
import lombok.Getter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.DecimalFormat;
import java.time.DateTimeException;
import java.util.List;

@Getter
@ToString
public class IndexTradeSummariesResponse {
    @JsonProperty("data")
    private List<IndexTradeSummariesResponseInner> data;

    @Getter
    @ToString
    public static class IndexTradeSummariesResponseInner {
        private String id;

        @JsonProperty("index")
        private IndexesResponse.IndexesResponseInner index;

        private String date;

        private Double value;

        private long volume;

        @JsonProperty("trade_count")
        private Integer tradeCount;

        @JsonProperty("buyer_count")
        private Integer buyerCount;

        @JsonProperty("advance_trade_count")
        private Integer advanceTradeCount;

        @JsonProperty("decline_trade_count")
        private Integer declineTradeCount;

        @JsonProperty("meta")
        private MetaResponse metaResponse;
    }
}
