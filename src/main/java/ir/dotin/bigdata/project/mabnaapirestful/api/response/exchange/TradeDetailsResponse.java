package ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.MetaResponse;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.InstrumentsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.TradesResponse;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class TradeDetailsResponse {
    @JsonProperty("data")
    private List<TradeDetailsResponseInner> data;

    @Getter
    @ToString
    public static class TradeDetailsResponseInner{
        private String id;

        private TradesResponse.TradesResponseInner trade;

        private InstrumentsResponse.InstrumentsResponseInner instrument;

        @JsonProperty("date_time")
        private String dateTime;

        @JsonProperty("person_buyer_count")
        private Long personBuyerCount;

        @JsonProperty("company_buyer_count")
        private Long companyBuyerCount;

        @JsonProperty("person_buy_volume")
        private Long personBuyVolume;

        @JsonProperty("company_buy_volume")
        private Long companyBuyVolume;

        @JsonProperty("person_seller_count")
        private Long personSellerCount;

        @JsonProperty("company_seller_count")
        private Long companySellerCount;

        @JsonProperty("person_sell_volume")
        private Long personSellVolume;

        @JsonProperty("company_sell_volume")
        private Long companySellVolume;

        @JsonProperty("meta")
        private MetaResponse metaResponse;

    }
}
