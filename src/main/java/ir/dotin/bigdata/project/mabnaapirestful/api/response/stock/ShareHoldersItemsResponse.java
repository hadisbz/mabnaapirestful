package ir.dotin.bigdata.project.mabnaapirestful.api.response.stock;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.EntityResponse;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.MetaResponse;
import lombok.Getter;
import lombok.ToString;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@Getter
@ToString
public class ShareHoldersItemsResponse {
    @JsonProperty("data")
    private List<ShareHoldersItemsResponseInner> data;

    @Getter
    @ToString
    public static class ShareHoldersItemsResponseInner{
        private String id;

        private ShareHoldersResponse.ShareHoldersResponseInner shareholders;

        private EntityResponse entity;

        private Double percentage;

        @JsonProperty("meta")
        private MetaResponse metaResponse;

    }

}
