package ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.MetaResponse;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class ReportSourcesResponse {
    @JsonProperty("data")
    private List<ReportSourcesResponseInner> data;

    @Getter
    @ToString
    public static class ReportSourcesResponseInner{
        private String id;

        private String title;

        @JsonProperty("meta")
        private MetaResponse metaResponse;
    }
}
