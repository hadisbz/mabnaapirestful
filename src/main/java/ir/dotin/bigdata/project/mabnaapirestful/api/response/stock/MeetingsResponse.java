package ir.dotin.bigdata.project.mabnaapirestful.api.response.stock;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.ReportsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.MetaResponse;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class MeetingsResponse {
    @JsonProperty("data")
    private List<MeetingsResponseInner> data;


    @Getter
    @ToString
    public static class MeetingsResponseInner{
        private String id;

        private CompaniesResponse.CompaniesResponseInner company;

        private ReportsResponse.ReportsResponseInner report;

        private MeetingTypesResponse.MeetingTypesResponseInner type;

        private String date;

        @JsonProperty("fiscal_year")
        private String fiscalYear;

        @JsonProperty("meta")
        private MetaResponse metaResponse;



    }
}
