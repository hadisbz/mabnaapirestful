package ir.dotin.bigdata.project.mabnaapirestful.mapper.fund;

import ir.dotin.bigdata.project.mabnaapirestful.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.broker.response.fund.FundsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.fund.FundsModel;

public class FundsMapper {
    public static FundsModel map(FundsResponse.FundsResponseInner fundsResponseInner) {
        String managerName = null;
        String managerEnglishName = null;
        String investmentManagerName = null;
        String investmentManagerEnglishName = null;
        String custodianName = null;
        String custodianEnglishName = null;
        String liquidityGuarantorName = null;
        String liquidityGuarantorEnglishName = null;
        String auditorName = null;
        String auditorEnglishName = null;
        String registrationManagerName = null;
        String registrationManagerEnglihName = null;
        String stateID = null;
        String exchangeId = null;

        if (fundsResponseInner.getManager() != null) {
            managerName = fundsResponseInner.getManager().getName();
            managerEnglishName = fundsResponseInner.getManager().getEnglishName();
        }

        if (fundsResponseInner.getInvestmentManager() != null) {
            investmentManagerName = fundsResponseInner.getInvestmentManager().getName();
            investmentManagerEnglishName = fundsResponseInner.getInvestmentManager().getEnglishName();
        }
        if (fundsResponseInner.getCustodian() != null) {
            custodianName = fundsResponseInner.getCustodian().getName();
            custodianEnglishName = fundsResponseInner.getCustodian().getEnglishName();
        }

        if (fundsResponseInner.getLiquidityGuarantor() != null) {
            liquidityGuarantorName = fundsResponseInner.getLiquidityGuarantor().getName();
            liquidityGuarantorEnglishName = fundsResponseInner.getLiquidityGuarantor().getEnglishName();
        }
        if (fundsResponseInner.getAuditor() != null) {
            auditorName = fundsResponseInner.getAuditor().getName();
            auditorEnglishName = fundsResponseInner.getAuditor().getEnglishName();
        }
        if (fundsResponseInner.getRegistrationManager() != null) {
            registrationManagerName = fundsResponseInner.getRegistrationManager().getName();
            registrationManagerEnglihName = fundsResponseInner.getRegistrationManager().getEnglishName();
        }
        if (fundsResponseInner.getState() != null) {
            stateID = fundsResponseInner.getState().getId();
        }
        if (fundsResponseInner.getExchange() != null) {
            exchangeId = fundsResponseInner.getExchange().getId();
        }

        return new FundsModel(
                fundsResponseInner.getId(),
                fundsResponseInner.getCode(),
                fundsResponseInner.getName(),
                fundsResponseInner.getEnglishName(),
                fundsResponseInner.getShortName(),
                fundsResponseInner.getEnglishShortName(),
                fundsResponseInner.getWebsite(),
                fundsResponseInner.getTradeSymbol(),
                fundsResponseInner.getEnglishTradeSymbol(),
                fundsResponseInner.getInceptionDate(),
                managerName,
                managerEnglishName,
                investmentManagerName,
                investmentManagerEnglishName,
                custodianName,
                custodianEnglishName,
                liquidityGuarantorName,
                liquidityGuarantorEnglishName,
                auditorName,
                auditorEnglishName,
                registrationManagerName,
                registrationManagerEnglihName,
                stateID,
                exchangeId,
                MetaMapper.map(fundsResponseInner.getMetaResponse())
        );
    }

}
