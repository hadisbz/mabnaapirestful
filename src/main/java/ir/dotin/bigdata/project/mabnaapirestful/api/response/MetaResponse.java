package ir.dotin.bigdata.project.mabnaapirestful.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class MetaResponse {
    public Long version;
    public String state;

    @JsonProperty("insert_date_time")
    public String insertDateTime;

    @JsonProperty("update_date_time")
    public String updateDateTime;

    @JsonProperty("delete_date_time")
    public String deleteDateTime;

    @JsonProperty("type")
    public String type;
}
