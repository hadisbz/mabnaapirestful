package ir.dotin.bigdata.project.mabnaapirestful.mapper.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.IndexTradeSummariesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.IndexTradeSummariesModel;

public class IndexTradeSummariesMapper {
    public static IndexTradeSummariesModel map(IndexTradeSummariesResponse.IndexTradeSummariesResponseInner indexTradeSummariesResponseInner) {
        String indexId = null;

        if(indexTradeSummariesResponseInner.getIndex() != null)
            indexId = indexTradeSummariesResponseInner.getIndex().getId();

        return new IndexTradeSummariesModel(
                indexTradeSummariesResponseInner.getId(),
                indexId,
                indexTradeSummariesResponseInner.getDate(),
                indexTradeSummariesResponseInner.getValue(),
                indexTradeSummariesResponseInner.getVolume(),
                indexTradeSummariesResponseInner.getTradeCount(),
                indexTradeSummariesResponseInner.getBuyerCount(),
                indexTradeSummariesResponseInner.getAdvanceTradeCount(),
                indexTradeSummariesResponseInner.getDeclineTradeCount(),
                MetaMapper.map(indexTradeSummariesResponseInner.getMetaResponse())
        );
    }

}
