package ir.dotin.bigdata.project.mabnaapirestful.api.response.stock;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.MetaResponse;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class MeetingTypesResponse {
    @JsonProperty("data")
    private List<MeetingTypesResponseInner> data;

    @Getter
    @ToString
    public static class MeetingTypesResponseInner {
        private String id;

        private String title;

        @JsonProperty("meta")
        private MetaResponse metaResponse;
    }
}
