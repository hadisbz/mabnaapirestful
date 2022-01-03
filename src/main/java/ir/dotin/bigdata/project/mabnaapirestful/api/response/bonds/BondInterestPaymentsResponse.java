package ir.dotin.bigdata.project.mabnaapirestful.api.response.bonds;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.MetaResponse;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.calendars.OccasionTypesResponse;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class BondInterestPaymentsResponse {
    @JsonProperty("data")
    private List<BondInterestPaymentsResponseInner> data;

    @Getter
    @ToString
    public static class BondInterestPaymentsResponseInner {
        @JsonProperty("bond")
        private BondResponse bondResponse;

        @JsonProperty("start_date")
        private String startDate;

        @JsonProperty("end_date")
        private String endDate;

        private Double interest;

        private String id;

        @JsonProperty("meta")
        private MetaResponse metaResponse;
    }
}
