package ir.dotin.bigdata.project.mabnaapirestful.api.response.bond;


import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.MetaResponse;
import lombok.Getter;

@Getter
public class BondResponse {
    private String id;

    @JsonProperty("meta")
    private MetaResponse metaResponse;
}
