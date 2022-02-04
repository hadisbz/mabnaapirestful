package ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.MetaResponse;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class IntradayTradesResponse {
    @JsonProperty("data")
    private List<IntradayTradesResponseInner> data;

    @Getter
    @ToString
    public static class IntradayTradesResponseInner{
        private String id;

        private TradesResponse.TradesResponseInner trade;

        private InstrumentsResponse.InstrumentsResponseInner instrument;

        @JsonProperty("date_time")
        private String dateTime;

        @JsonProperty("close_price")
        private Double closePrice;

        @JsonProperty("real_close_price")
        private Double realClosePrice;

        private Long volume;

        private Double value;

        @JsonProperty("trade_count")
        private Long tradeCount;

        @JsonProperty("open_price")
        private Double openPrice;

        @JsonProperty("low_price")
        private  Double lowPrice;

        @JsonProperty("high_price")
        private Double highPrice;

        @JsonProperty("meta")
        private MetaResponse metaResponse;
    }
}
