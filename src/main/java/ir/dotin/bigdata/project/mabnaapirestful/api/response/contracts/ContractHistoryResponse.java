package ir.dotin.bigdata.project.mabnaapirestful.api.response.contracts;
import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.MetaResponse;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.ReportsResponse;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
@Getter
@ToString
public class ContractHistoryResponse {
    @JsonProperty("data")
    private List<ContractHistoryResponseInner> data;

    @Getter
    @ToString
    public static class ContractHistoryResponseInner{

        private String id;

        private ContractsResponse.ContractsResponseInner contract;

        private ReportsResponse.ReportsResponseInner report;

        @JsonProperty("change_date")
        private String changeDate;

        @JsonProperty("exercise_price")
        private Double exercisePrice;

        @JsonProperty("meta")
        private MetaResponse metaResponse;



    }

}
