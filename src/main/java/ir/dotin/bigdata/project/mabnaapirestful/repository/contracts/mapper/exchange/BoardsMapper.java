package ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.BoardsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.BoardsModel;

public class BoardsMapper {
    public static BoardsModel map(BoardsResponse.BoardsResponseInner BoardsResponseInner){
        return new BoardsModel(
                BoardsResponseInner.getId(),
                BoardsResponseInner.getTitle(),
                BoardsResponseInner.getEnglishTitle(),
                BoardsResponseInner.getCode(),
                MetaMapper.map(BoardsResponseInner.getMetaResponse())
        );
    }
}
