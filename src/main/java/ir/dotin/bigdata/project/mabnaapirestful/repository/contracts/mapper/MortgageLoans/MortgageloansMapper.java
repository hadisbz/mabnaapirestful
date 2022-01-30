package ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.MortgageLoans;

import ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.mortgageLoans.MortgageLoansResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.mortgageLoans.MortgageLoansModel;

public class MortgageloansMapper {
    public static MortgageLoansModel map(MortgageLoansResponse.MortgageLoansResponseInner mortgageloansResponseInner){
        String exchangId = null;
        if(mortgageloansResponseInner.getExchange() != null)
            exchangId = mortgageloansResponseInner.getExchange().getId();

        return new MortgageLoansModel(
                mortgageloansResponseInner.getId(),
                mortgageloansResponseInner.getName(),
                mortgageloansResponseInner.getEnglishName(),
                mortgageloansResponseInner.getShortName(),
                mortgageloansResponseInner.getEnglishShortName(),
                mortgageloansResponseInner.getTradeSymbol(),
                mortgageloansResponseInner.getEnglishTradeSymbol(),
                exchangId,
                MetaMapper.map(mortgageloansResponseInner.getMetaResponse())
        );
    }

}
