package ir.dotin.bigdata.project.mabnaapirestful.api.response.mortgageLoans;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.MetaResponse;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.ExchangesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.IndexValuesResponse;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
@Getter
@ToString
public class MortgageLoansResponse {
    @JsonProperty("data")
    private List<MortgageLoansResponseInner> data;

    @Getter
    @ToString
    public static class MortgageLoansResponseInner {

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

        @JsonProperty("exchange")
        private ExchangesResponse.ExchangesResponseInner exchange;

        @JsonProperty("meta")
        private MetaResponse metaResponse;


    }
}
