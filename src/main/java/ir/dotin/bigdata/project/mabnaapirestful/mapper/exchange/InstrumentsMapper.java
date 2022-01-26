package ir.dotin.bigdata.project.mabnaapirestful.mapper.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.InstrumentsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.InstrumentsModel;

public class InstrumentsMapper {
    public static InstrumentsModel map(InstrumentsResponse.InstrumentsResponseInner instrumentsResponseInner){
        String exchangeId=null;
        String marketId=null;
        String boardId=null;
        String groupId = null;
        String exchangeStateId=null;
        String companyId=null;
        String optionContractId=null;
        String indexId = null;
        String mainInstrumentId=null;
        String parentInstrumentId=null;

        if(instrumentsResponseInner.getExchange()!=null)
            exchangeId = instrumentsResponseInner.getExchange().getId();

        if(instrumentsResponseInner.getMarket()!=null)
            marketId = instrumentsResponseInner.getMarket().getId();

        if(instrumentsResponseInner.getBoard()!=null)
            boardId=instrumentsResponseInner.getBoard().getId();

        if(instrumentsResponseInner.getGroup()!=null)
            groupId=instrumentsResponseInner.getGroup().getId();

        if(instrumentsResponseInner.getExchangeState()!=null)
            exchangeStateId = instrumentsResponseInner.getExchangeState().getId();

        if(instrumentsResponseInner.getStock()!=null)
            if(instrumentsResponseInner.getStock().getCompany()!=null)
                companyId=instrumentsResponseInner.getStock().getCompany().getId();

        if(instrumentsResponseInner.getOptionContract()!=null)
            optionContractId = instrumentsResponseInner.getOptionContract().getId();

        if(instrumentsResponseInner.getIndex()!=null)
            indexId=instrumentsResponseInner.getIndex().getId();

        if(instrumentsResponseInner.getMainInstrument()!=null)
            mainInstrumentId=instrumentsResponseInner.getMainInstrument().getId();

        if(instrumentsResponseInner.getParentInstrument()!=null)
            parentInstrumentId=instrumentsResponseInner.getParentInstrument().getId();

        return new InstrumentsModel(
                null,
                instrumentsResponseInner.getId(),
                instrumentsResponseInner.getCode(),
                instrumentsResponseInner.getBbsCode(),
                instrumentsResponseInner.getIsin(),
                instrumentsResponseInner.getName(),
                instrumentsResponseInner.getEnglishName(),
                instrumentsResponseInner.getShortName(),
                instrumentsResponseInner.getEnglishShortName(),
                instrumentsResponseInner.getType(),
                exchangeId,
                marketId,
                boardId,
                groupId,
                instrumentsResponseInner.getValueType(),
                instrumentsResponseInner.getBaseVolume(),
                instrumentsResponseInner.getNominalPrice(),
                instrumentsResponseInner.getPriceTick(),
                instrumentsResponseInner.getTradeTick(),
                instrumentsResponseInner.getPaymentDelay(),
                instrumentsResponseInner.getMinimumVolumePermit(),
                instrumentsResponseInner.getMaximumVolumePermit(),
                exchangeStateId,
                companyId,
                optionContractId,
                indexId,
                mainInstrumentId,
                parentInstrumentId,
                instrumentsResponseInner.getListingDate(),
                instrumentsResponseInner.getShareCount(),
                MetaMapper.map(instrumentsResponseInner.getMetaResponse())



        );
    }

}
