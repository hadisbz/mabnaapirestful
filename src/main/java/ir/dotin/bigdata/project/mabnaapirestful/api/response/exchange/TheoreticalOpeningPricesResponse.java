package ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.MetaResponse;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class TheoreticalOpeningPricesResponse {
    @JsonProperty("data")
    private List<TheoreticalOpeningPricesResponseInner> data;

    @Getter
    @ToString
    public static class TheoreticalOpeningPricesResponseInner {
        private String id;

        private InstrumentsResponse.InstrumentsResponseInner instrument;

        @JsonProperty("date_time")
        private String dateTime;

        private Long price;

        @JsonProperty("meta")
        private MetaResponse metaResponse;
    }
}
