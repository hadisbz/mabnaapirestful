package ir.dotin.bigdata.project.mabnaapirestful.api.response.bond;


import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.MetaResponse;
import lombok.Value;

@Value
public class BondResponse {
    public String id;

    @JsonProperty("meta")
    public MetaResponse metaResponse;
}
