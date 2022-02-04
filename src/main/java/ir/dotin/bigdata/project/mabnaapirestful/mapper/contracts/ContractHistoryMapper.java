package ir.dotin.bigdata.project.mabnaapirestful.mapper.contracts;

import ir.dotin.bigdata.project.mabnaapirestful.api.response.contracts.ContractHistoryResponse;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.contracts.ContractHistoryModel;

public class ContractHistoryMapper {
    public static ContractHistoryModel map(ContractHistoryResponse.ContractHistoryResponseInner contractHistoryResponseInner){
        String contractId=null;
        String reportId=null;

        if(contractHistoryResponseInner.getContract()!=null)
            contractId=contractHistoryResponseInner.getContract().getId();

        if(contractHistoryResponseInner.getReport()!=null)
            reportId=contractHistoryResponseInner.getReport().getId();

        return new ContractHistoryModel(
                contractHistoryResponseInner.getId(),
                contractId,
                reportId,
                contractHistoryResponseInner.getChangeDate(),
                contractHistoryResponseInner.getExercisePrice(),
                MetaMapper.map(contractHistoryResponseInner.getMetaResponse())
        );
    }
}
