package ir.dotin.bigdata.project.mabnaapirestful.model.broker.response.exchange;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.model.broker.response.MetaResponse;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class InstrumentGroupStateTypesResponse {
    @JsonProperty("data")
    private List<InstrumentGroupStateTypesResponse.InstrumentGroupStateTypesResponseInner> data;

    @Getter
    @ToString
    public static class InstrumentGroupStateTypesResponseInner {
        private String id;

        private String title;

        @JsonProperty("english_title")
        private String englishTitle;

        @JsonProperty("meta")
        private MetaResponse metaResponse;
    }
}
