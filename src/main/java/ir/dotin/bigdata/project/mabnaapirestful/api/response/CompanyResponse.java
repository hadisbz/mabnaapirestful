package ir.dotin.bigdata.project.mabnaapirestful.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CompanyResponse {
    private String id;

    @JsonProperty("meta")
    private MetaResponse metaResponse;
}
