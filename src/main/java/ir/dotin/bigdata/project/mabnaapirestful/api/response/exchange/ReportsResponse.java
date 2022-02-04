package ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.EntityResponse;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.MetaResponse;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.StockResponse;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class ReportsResponse {
    @JsonProperty("data")
    private List<ReportsResponseInner> data;

    @Getter
    @ToString
    public static class ReportsResponseInner {
        private String id;

        private String date;

        private String number;

        private SourcesResponse.SourcesResponseInner source;

        private ReportTitlesResponse.ReportTitlesResponseInner title;

        @JsonProperty("fiscal_year")
        private String fiscalYear;

        private List<ReportSubTitlesResponse.ReportSubTitlesResponseInner> subtitles ;

        private StockResponse stock;

        private EntityResponse entity;

        private List<ReportImagesResponse.ReportImagesResponseInner> images;

        @JsonProperty("meta")
        private MetaResponse metaResponse;
    }

}
