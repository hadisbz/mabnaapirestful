package ir.dotin.bigdata.project.mabnaapirestful.api.response.bonds;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.MetaResponse;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class InterestPaymentsResponse {
    @JsonProperty("data")
    private List<InterestPaymentsResponseInner> data;

    @Getter
    @ToString
    public static class InterestPaymentsResponseInner{
        private String id;

        private BondsResponse.BondsResponseInner bond;

        @JsonProperty("start_date")
        private String startDate;

        @JsonProperty("end_date")
        private String endDate;

        private Double interest;

        @JsonProperty("meta")
        private MetaResponse metaResponse;

    }
}
