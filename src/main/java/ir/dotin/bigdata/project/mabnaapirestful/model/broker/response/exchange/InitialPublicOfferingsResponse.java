package ir.dotin.bigdata.project.mabnaapirestful.model.broker.response.exchange;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.model.broker.response.MetaResponse;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class InitialPublicOfferingsResponse {
    @JsonProperty("data")
    private List<InitialPublicOfferingsResponseInner> data;

    @Getter
    @ToString
    public static class InitialPublicOfferingsResponseInner {
        private String id;

        private InstrumentsResponse.InstrumentsResponseInner instrument;

        @JsonProperty("start_date_time")
        private String startDateTime;

        @JsonProperty("end_date_time")
        private String endDateTime;

        @JsonProperty("min_price_permit")
        private Double minPricePermit;

        @JsonProperty("max_price_permit")
        private Double maxPricePermit;

        @JsonProperty("min_volume_permit")
        private Long minVolumePermit;

        @JsonProperty("max_volume_permit")
        private Long maxVolumePermit;

        @JsonProperty("start_trading_date")
        private String startTradingDate;

        @JsonProperty("allotment_date")
        private String allotmentDate;

        @JsonProperty("meta")
        private MetaResponse metaResponse;
    }
}
