package ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.EntityResponse;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.MetaResponse;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.stock.CompaniesResponse;
import lombok.Getter;
import lombok.ToString;

import javax.swing.text.html.parser.Entity;
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

        private EntityResponse entity;

        @JsonProperty("meta")
        private MetaResponse metaResponse;
    }

}
