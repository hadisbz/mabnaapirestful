package ir.dotin.bigdata.project.mabnaapirestful.model.broker.response.exchange;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.model.broker.response.MetaResponse;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class IndexInstrumentsResponse {
        @JsonProperty("data")
        private List<IndexInstrumentsResponseInner> data;

        @Getter
        @ToString
        public static class IndexInstrumentsResponseInner {
            private String id;

            private IndexesResponse.IndexesResponseInner index;

            private InstrumentsResponse.InstrumentsResponseInner instrument;

            @JsonProperty("meta")
            private MetaResponse metaResponse;
        }
    }
