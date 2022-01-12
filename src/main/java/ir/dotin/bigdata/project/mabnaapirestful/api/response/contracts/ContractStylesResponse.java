package ir.dotin.bigdata.project.mabnaapirestful.api.response.contracts;
import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.MetaResponse;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.contracts.ContractStylesResponse;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString

public class ContractStylesResponse {
    @JsonProperty("data")
    private List<ContractStylesResponse.ContractStylesResponseInner> data;

    @Getter
    @ToString
    public static class ContractStylesResponseInner {
        private String id;

        private String title;

        @JsonProperty("english_title")
        private String englishTitle;

        @JsonProperty("meta")
        private MetaResponse metaResponse;
    }
}
