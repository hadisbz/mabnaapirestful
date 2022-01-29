package ir.dotin.bigdata.project.mabnaapirestful.model.broker.response.exchange;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.model.broker.response.MetaResponse;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class ReportImagesResponse {
    @JsonProperty("data")
    private List<ReportImagesResponse.ReportImagesResponseInner> data;

    @Getter
    @ToString
    public static class ReportImagesResponseInner {
        private String id;

        @JsonProperty("report")
        private ReportsResponse.ReportsResponseInner reportsResponseInner;

        @JsonProperty("content_type")
        private String contentType;

        @JsonProperty("content_length")
        private Long contentLength;

        @JsonProperty("meta")
        private MetaResponse metaResponse;
    }
}