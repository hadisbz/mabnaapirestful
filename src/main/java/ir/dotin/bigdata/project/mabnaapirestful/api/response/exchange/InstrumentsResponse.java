package ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.MetaResponse;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.StockResponse;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.contracts.ContractsResponse;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class InstrumentsResponse {
    @JsonProperty("data")
    private List<InstrumentsResponseInner> data;

    @Getter
    @ToString
    public static class InstrumentsResponseInner{
        private String id;

        private String code;

        @JsonProperty("bbs_code")
        private String bbsCode;

        private String isin;

        private String name;

        @JsonProperty("english_name")
        private String englishName;

        @JsonProperty("short_name")
        private String shortName;

        @JsonProperty("english_short_name")
        private String englishShortName;

        private String type;

        private ExchangesResponse.ExchangesResponseInner exchange;

        private MarketsResponse.MarketsResponseInner market;

        private BoardsResponse.BoardsResponseInner board;

        private InstrumentGroupsResponse.InstrumentGroupsResponseInner group;

        @JsonProperty("value_type")
        private String valueType;

        @JsonProperty("base_volume")
        private Integer baseVolume;

        @JsonProperty("nominal_price")
        private Double nominalPrice;

        @JsonProperty("price_tick")
        private Integer priceTick;

        @JsonProperty("trade_tick")
        private Integer tradeTick;

        @JsonProperty("payment_delay")
        private Integer paymentDelay;

        @JsonProperty("minimum_volume_permit")
        private Long minimumVolumePermit;

        @JsonProperty("maximum_volume_permit")
        private Long maximumVolumePermit;

        @JsonProperty("exchange_state")
        private InstrumentExchangeStatesResponse.InstrumentExchangeStatesResponseInner exchangeState;

        @JsonProperty("stock")
        private StockResponse stock;

        @JsonProperty("option.contract")
        private ContractsResponse.ContractsResponseInner optionContract;

        private IndexesResponse.IndexesResponseInner index;

        @JsonProperty("main_instrument")
        private ParentResponse mainInstrument;

        @JsonProperty("parent_instrument")
        private ParentResponse parentInstrument;

        @JsonProperty("listing_date")
        private String listingDate;

        @JsonProperty("share_count")
        private Long shareCount;

        @JsonProperty("meta")
        private MetaResponse metaResponse;


    }

}
