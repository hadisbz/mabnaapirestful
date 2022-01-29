package ir.dotin.bigdata.project.mabnaapirestful.model.broker.response.bonds;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.model.broker.response.MetaResponse;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class BondAuthorityTypesResponse {
    @JsonProperty("data")
    private List<BondAuthorityTypesResponseInner> data;

    @Getter
    @ToString
    public static class BondAuthorityTypesResponseInner {
        private String id;

        private String title;

        @JsonProperty("meta")
        private MetaResponse metaResponse;
    }

}
