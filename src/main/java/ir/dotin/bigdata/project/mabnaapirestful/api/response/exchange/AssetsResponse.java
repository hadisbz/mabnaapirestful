package ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.EntityResponse;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.MetaResponse;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.StockResponse;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.fund.FundsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.mortgageLoans.MortgageLoansResponse;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class AssetsResponse {
    @JsonProperty("data")
    private List<AssetsResponseInner> data;

    @Getter
    @ToString
    public static class AssetsResponseInner {
        private String id;

        private AssetTypesResponse.AssetTypesResponseInner type;

        @JsonProperty("trade_symbol")
        private String tradeSymbol;

        @JsonProperty("english_trade_symbol")
        private String englishTradeSymbol;

        private String name;

        @JsonProperty("english_name")
        private String englishName;

        @JsonProperty("categories")
        private List<CategoriesResponse.CategoriesResponseInner> categoriesResponses;

        @JsonProperty("short_name")
        private String shortName;

        @JsonProperty("english_short_name")
        private String englishShortName;

        private ExchangesResponse.ExchangesResponseInner exchange;

        private AssetStatesResponse.AssetStatesResponseInner state;

        private StockResponse stock;

        private FundsResponse.FundsResponseInner fund;

        @JsonProperty("mortgage_loan")
        private MortgageLoansResponse.MortgageLoansResponseInner mortgageLoan;

        @JsonProperty("fingilish_name")
        private String fingilishName;

        @JsonProperty("fingilish_short_name")
        private String fingilishShortName;

        @JsonProperty("fingilish_trade_symbol")
        private  String fingilishTradeSymbol;

        @JsonProperty("state_change_date")
        private String stateChangeDate;

        @JsonProperty("state_description")
        private String stateDescription;

        @JsonProperty("english_state_description")
        private String englishStateDescription;

        private EntityResponse entity;

        @JsonProperty("meta")
        private MetaResponse metaResponse;
    }

}
