package ir.dotin.bigdata.project.mabnaapirestful.api.response.fund;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.MetaResponse;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.ExchangesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.InstrumentExchangeStatesResponse;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
@Getter
@ToString
public class FundsResponse {
    @JsonProperty("data")
    private List<FundsResponseInner> data;

    @Getter
    @ToString
    public static class FundsResponseInner {
        private String id;

        private String code;

        private String name;

        @JsonProperty("english_name")
        private String englishName;

        @JsonProperty("short_name")
        private String shortName;

        @JsonProperty("english_short_name")
        private String englishShortName;

        private String website;

        @JsonProperty("trade_symbol")
        private String tradeSymbol;

        @JsonProperty("english_trade_symbol")
        private String englishTradeSymbol;

        @JsonProperty("inception_date")
        private String inceptionDate;

        private NameRespons manager;

        @JsonProperty("investment_manager")
        private NameRespons investmentManager;

        private NameRespons custodian;

        @JsonProperty("liquidity_guarantor")
        private NameRespons liquidityGuarantor;

        private NameRespons auditor;

        @JsonProperty("registration_manager")
        private NameRespons registrationManager;


        private InstrumentExchangeStatesResponse.InstrumentExchangeStatesResponseInner state;

        private ExchangesResponse.ExchangesResponseInner exchange;

        @JsonProperty("meta")
        private MetaResponse metaResponse;
    }
}
