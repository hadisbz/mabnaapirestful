package ir.dotin.bigdata.project.mabnaapirestful.model.api.response.exchange;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.model.api.response.MetaResponse;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class MarketMessagesResponse {
    @JsonProperty("data")
    private List<MarketMessagesResponseInner> data;

    @Getter
    @ToString
    public static class MarketMessagesResponseInner{
        private String id;

        @JsonProperty("date_time")
        private String dateTime;

        private String title;

        private String text;

        @JsonProperty("meta")
        private MetaResponse metaResponse;
    }
}
