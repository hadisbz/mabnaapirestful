package ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.MetaResponse;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class BoardsResponse {
    @JsonProperty("data")
    private List<BoardsResponse.BoardsResponseInner> data;

    @Getter
    @ToString
    public static class BoardsResponseInner {
        private String id;

        private String code;

        private String title;

        @JsonProperty("english_title")
        private String englishTitle;

        @JsonProperty("meta")
        private MetaResponse metaResponse;
    }
}
