package ir.dotin.bigdata.project.mabnaapirestful.model.api.response.fund;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.model.api.response.MetaResponse;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
@Getter
@ToString
public class DividendPaymentsResponse {
    @JsonProperty("data")
    private List<DividendPaymentsResponseInner> data;

    @Getter
    @ToString
    public static class DividendPaymentsResponseInner {
        private String id;

        private FundsResponse.FundsResponseInner fund;

        private String date;

        private Double dividend;

        @JsonProperty("meta")
        private MetaResponse metaResponse;
    }
}
