package ir.dotin.bigdata.project.mabnaapirestful.model.broker.response.contracts;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.model.broker.response.EntityResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.broker.response.MetaResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.broker.response.exchange.ExchangesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.broker.response.stock.CompaniesResponse;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
@Getter
@ToString
public class ContractsResponse {
    @JsonProperty("data")
    private List<ContractsResponseInner> data;

    @Getter
    @ToString
    public static class ContractsResponseInner {
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

        @JsonProperty("publisher_company")
        private CompaniesResponse.CompaniesResponseInner publisherCompany;

        @JsonProperty("trade_start_date")
        private String tradeStartDate;

        @JsonProperty("trade_end_date")
        private String tradeEndDate;

        @JsonProperty("exercise_date")
        private String exerciseDate;

        @JsonProperty("exercise_price")
        private Double exercisePrice;

        @JsonProperty("type")
        private ContractTypesResponse.ContractTypesResponseInner type;

        @JsonProperty("style")
        private ContractStylesResponse.ContractStylesResponseInner style;

        @JsonProperty("entity")
        private EntityResponse entity;

        @JsonProperty("meta")
        private MetaResponse metaResponse;
    }

}
