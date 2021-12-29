package ir.dotin.bigdata.project.mabnaapirestful.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class BondAuthorityTypesResponse {
    String id;
    String title;

    @JsonProperty("meta")
    MetaResponse metaResponse;
}
