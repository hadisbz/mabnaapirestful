package ir.dotin.bigdata.project.mabnaapirestful.api.response.stock;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.ExchangesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.InstrumentExchangeStatesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.MetaResponse;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
@Getter
@ToString
public class CompaniesResponse {
    @JsonProperty("data")
    private List<CompaniesResponseInner> data;

    @Getter
    @ToString
    public static class CompaniesResponseInner {
        private String id;

        private String name;

        @JsonProperty("english_name")
        private String englishName;

        @JsonProperty("short_name")
        private String shortName;

        @JsonProperty("english_short_name")
        private String englishShortName;

        @JsonProperty("trade_symbol")
        private String tradeSymbol;

        @JsonProperty("english_trade_symbol")
        private String englishTradeSymbol;

        private String description;

        private String fiscalyear;

        @JsonProperty("state")
        private InstrumentExchangeStatesResponse.InstrumentExchangeStatesResponseInner state;

        @JsonProperty("exchange")
        private ExchangesResponse.ExchangesResponseInner exchange;

        @JsonProperty("meta")
        private MetaResponse metaResponse;
    }
}
