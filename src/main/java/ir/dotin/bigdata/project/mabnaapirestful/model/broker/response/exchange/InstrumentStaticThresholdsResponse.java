package ir.dotin.bigdata.project.mabnaapirestful.model.broker.response.exchange;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.model.broker.response.MetaResponse;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class InstrumentStaticThresholdsResponse {
    @JsonProperty("data")
    private List<InstrumentStaticThresholdsResponseInner> data;

    @Getter
    @ToString
    public static class InstrumentStaticThresholdsResponseInner {
        private String id;

        private InstrumentsResponse.InstrumentsResponseInner instrument;

        @JsonProperty("date_time")
        private String dateTime;

        @JsonProperty("min_price_permit")
        private  Integer minPricePermit;

        @JsonProperty("max_price_permit")
        private Integer maxPricePermit;

        @JsonProperty("meta")
        private MetaResponse metaResponse;
    }
}
