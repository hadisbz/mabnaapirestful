package ir.dotin.bigdata.project.mabnaapirestful.api.response.stock;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.MetaResponse;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.ReportsResponse;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class DividendPayoutsResponse {
    @JsonProperty("data")
    private List<DividendPayoutsResponseInner> data;

    @Getter
    @ToString
    public static class DividendPayoutsResponseInner {
        private String id;

        private MeetingsResponse.MeetingsResponseInner meeting;

        private ReportsResponse.ReportsResponseInner report;

        private String date;

        @JsonProperty("announcement_date")
        private String announcementDate;

        @JsonProperty("meta")
        private MetaResponse metaResponse;

    }
}
