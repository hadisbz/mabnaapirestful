package ir.dotin.bigdata.project.mabnaapirestful.mapper.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.broker.response.exchange.BoardsResponse;
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
