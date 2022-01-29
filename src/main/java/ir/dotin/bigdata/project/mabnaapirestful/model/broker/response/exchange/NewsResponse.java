package ir.dotin.bigdata.project.mabnaapirestful.model.broker.response.exchange;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.model.broker.response.EntityResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.broker.response.MetaResponse;
import lombok.Getter;
import lombok.ToString;


import javax.persistence.Lob;
import java.util.List;

@Getter
@ToString
public class NewsResponse {
    @JsonProperty("data")
    private List<NewsResponseInner> data;

    @Getter
    @ToString
    public static class NewsResponseInner {
        private String id;

        public EntityResponse entity;

        public SourcesResponse.SourcesResponseInner source;

        public String date;

        @Lob
        public String title;

        @Lob
        public String text;

        @JsonProperty("meta")
        private MetaResponse metaResponse;
    }
}
