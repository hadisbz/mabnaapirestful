package ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.IndexIntradayTradeSummariesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.IndexIntradayTradeSummariesModel;

public class IndexIntradayTradeSummariesMapper {
    public static IndexIntradayTradeSummariesModel map(IndexIntradayTradeSummariesResponse.IndexIntradayTradeSummariesResponseInner indexIntradayTradeSummariesResponseInner) {
        String indexId = null;

        if (indexIntradayTradeSummariesResponseInner.getIndex() != null)
            indexId = indexIntradayTradeSummariesResponseInner.getIndex().getId();

        return new IndexIntradayTradeSummariesModel(
                indexIntradayTradeSummariesResponseInner.getId(),
                indexId,
                indexIntradayTradeSummariesResponseInner.getDateTime(),
                indexIntradayTradeSummariesResponseInner.getValue(),
                indexIntradayTradeSummariesResponseInner.getVolume(),
                indexIntradayTradeSummariesResponseInner.getTradeCount(),
                indexIntradayTradeSummariesResponseInner.getBuyerCount(),
                indexIntradayTradeSummariesResponseInner.getAdvanceTradeCount(),
                indexIntradayTradeSummariesResponseInner.getDeclineTradeCount(),
                MetaMapper.map(indexIntradayTradeSummariesResponseInner.getMetaResponse())
        );
    }

}
