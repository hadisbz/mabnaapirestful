package ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.MetaResponse;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class InstrumentBaseVolumesResponse {
    @JsonProperty("data")
    private List<InstrumentBaseVolumesResponseInner> data;

    @Getter
    @ToString
    public static class InstrumentBaseVolumesResponseInner {
        private String id;

        private InstrumentsResponse.InstrumentsResponseInner instrument;

        @JsonProperty("date_time")
        private String dateTime;

        @JsonProperty("base_volume")
        private Integer baseVolume;

        @JsonProperty("meta")
        private MetaResponse metaResponse;

    }
}
