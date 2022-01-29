package ir.dotin.bigdata.project.mabnaapirestful.model.broker.response.stock;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.model.broker.response.EntityResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.broker.response.MetaResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.broker.response.exchange.PersonsResponse;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class BoardOfDirectorsItemsResponse {
    @JsonProperty("data")
    private List<BoardOfDirectorsItemsResponseInner> data;

    @Getter
    @ToString
    public static class BoardOfDirectorsItemsResponseInner {
        private String id;

        @JsonProperty("board_of_directors")
        private BoardOfDirectorsResponse.BoardOfDirectorsResponseInner boardOfDirectors;

        private EntityResponse director;

        private PositionsResponse.PositionsResponseInner position;

        private PersonsResponse.PersonsResponseInner agent;

        private DirectorTypesResponse.DirectorTypesResponseInner type;

        @JsonProperty("meta")
        private MetaResponse metaResponse;
    }
}
