package ir.dotin.bigdata.project.mabnaapirestful.mapper.contracts;

import ir.dotin.bigdata.project.mabnaapirestful.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.broker.response.contracts.ContractsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.contracts.ContractsModel;

public class ContractsMapper {
    public static ContractsModel map(ContractsResponse.ContractsResponseInner contractsResponseInner){
        String exchangeId = null;
        String publisherCompanyId = null;
        String typeId = null;
        String styleId = null;
        String entityId = null;


        if(contractsResponseInner.getExchange()!=null)
            exchangeId = contractsResponseInner.getExchange().getId();

        if(contractsResponseInner.getPublisherCompany()!=null)
            publisherCompanyId = contractsResponseInner.getPublisherCompany().getId();

        if(contractsResponseInner.getType()!=null)
            typeId = contractsResponseInner.getType().getId();

        if(contractsResponseInner.getStyle()!=null)
            styleId = contractsResponseInner.getStyle().getId();

        if(contractsResponseInner.getEntity()!=null)
            entityId = contractsResponseInner.getEntity().getId();


        return new ContractsModel(
                contractsResponseInner.getId(),
                contractsResponseInner.getName(),
                contractsResponseInner.getEnglishName(),
                contractsResponseInner.getShortName(),
                contractsResponseInner.getEnglishShortName(),
                contractsResponseInner.getTradeSymbol(),
                contractsResponseInner.getEnglishTradeSymbol(),
                exchangeId,
                publisherCompanyId,
                contractsResponseInner.getTradeStartDate(),
                contractsResponseInner.getTradeEndDate(),
                contractsResponseInner.getExerciseDate(),
                contractsResponseInner.getExercisePrice(),
                typeId,
                entityId,
                styleId,
                MetaMapper.map(contractsResponseInner.getMetaResponse())
        );
    }
}
