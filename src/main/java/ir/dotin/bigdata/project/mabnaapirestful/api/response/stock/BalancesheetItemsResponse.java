package ir.dotin.bigdata.project.mabnaapirestful.api.response.stock;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.MetaResponse;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class BalancesheetItemsResponse {
    @JsonProperty("data")
    private List<BalancesheetItemsResponseInner> data;


    @Getter
    @ToString
    public static class BalancesheetItemsResponseInner{
        private String id;

        @JsonProperty("balance_sheet")
        private BalancesheetsResponse.BalancesheetsResponseInner balanceSheet;

        private BalancesheetFieldsResponse.BalancesheetFieldsResponseInner field;

        private Double value;

        @JsonProperty("meta")
        private MetaResponse metaResponse;

    }
}
