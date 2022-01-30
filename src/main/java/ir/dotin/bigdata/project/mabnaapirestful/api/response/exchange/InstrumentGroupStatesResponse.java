package ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.MetaResponse;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class InstrumentGroupStatesResponse {
    @JsonProperty("data")
    private List<InstrumentGroupStatesResponseInner> data;

    @Getter
    @ToString
    public static class InstrumentGroupStatesResponseInner {
        private String id;

        private InstrumentGroupsResponse.InstrumentGroupsResponseInner group;

        private InstrumentGroupStateTypesResponse.InstrumentGroupStateTypesResponseInner type;

        @JsonProperty("date_time")
        private String dateTime;

        @JsonProperty("meta")
        private MetaResponse metaResponse;
    }
    }
