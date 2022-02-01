package ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.InstrumentStateStateResponse;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.InstrumentStateTypeResponse;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.MetaResponse;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class InstrumentStatesResponse {
    @JsonProperty("data")
    private List<InstrumentStatesResponseInner> data;

    @Getter
    @ToString
    public static  class InstrumentStatesResponseInner{
        private String id;

        private InstrumentsResponse.InstrumentsResponseInner instrument;

        @JsonProperty("date_time")
        private String dateTime;

        private String date;

        private InstrumentStateTypeResponse type;

        private InstrumentStateStateResponse state;

        @JsonProperty("meta")
        private MetaResponse metaResponse;

    }
}
