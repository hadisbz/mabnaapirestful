package ir.dotin.bigdata.project.mabnaapirestful.api.response.stock;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.MetaResponse;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class CashFlowItemsResponse {
    @JsonProperty("data")
    private List<CashFlowItemsResponseInner> data;

    @Getter
    @ToString
    public static class CashFlowItemsResponseInner {
        private String id;

        @JsonProperty("cash_flow")
        private CashFlowsResponse.CashFlowsResponseInner cashFlow;

        private CashflowFieldsResponse.CashflowFieldsResponseInner field;

        private Long value;

        @JsonProperty("meta")
        private MetaResponse metaResponse;
    }

}
