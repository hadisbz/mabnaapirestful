package ir.dotin.bigdata.project.mabnaapirestful.mapper.stock;

import ir.dotin.bigdata.project.mabnaapirestful.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.broker.response.stock.BoardOfDirectorsItemsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.stock.BoardOfDirectorsItemsModel;

public class BoardOfDirectorsItemsMapper {
    public static BoardOfDirectorsItemsModel map(BoardOfDirectorsItemsResponse.BoardOfDirectorsItemsResponseInner boardOfdirectorsItemsResponseInner){
        String boardOfDirectorsId=null;
        String directorId=null;
        String positionId=null;
        String agentId=null;
        String typeId=null;

        if(boardOfdirectorsItemsResponseInner.getBoardOfDirectors()!=null)
            boardOfDirectorsId=boardOfdirectorsItemsResponseInner.getBoardOfDirectors().getId();

        if(boardOfdirectorsItemsResponseInner.getDirector()!=null)
            directorId=boardOfdirectorsItemsResponseInner.getDirector().getId();

        if(boardOfdirectorsItemsResponseInner.getPosition()!=null)
            positionId=boardOfdirectorsItemsResponseInner.getPosition().getId();

        if(boardOfdirectorsItemsResponseInner.getAgent()!=null)
            agentId=boardOfdirectorsItemsResponseInner.getAgent().getId();

        if(boardOfdirectorsItemsResponseInner.getType()!=null)
            typeId=boardOfdirectorsItemsResponseInner.getType().getId();

        return new BoardOfDirectorsItemsModel(
                boardOfdirectorsItemsResponseInner.getId(),
                boardOfDirectorsId,
                directorId,
                positionId,
                agentId,
                typeId,
                MetaMapper.map(boardOfdirectorsItemsResponseInner.getMetaResponse())
        );
    }
}
