package ir.dotin.bigdata.project.mabnaapirestful.model.broker.response.exchange;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.model.broker.response.MetaResponse;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class IndexInstrumentEffectsResponse {
    @JsonProperty("data")
    private List<IndexInstrumentEffectsResponseInner> data;

    @Getter
    @ToString
    public static class IndexInstrumentEffectsResponseInner {
        private String id;

        private InstrumentsResponse.InstrumentsResponseInner instrument;

        private IndexesResponse.IndexesResponseInner index;

        @JsonProperty("date_time")
        private String dateTime;

        private Double effect;

        @JsonProperty("meta")
        private MetaResponse metaResponse;

    }
}
