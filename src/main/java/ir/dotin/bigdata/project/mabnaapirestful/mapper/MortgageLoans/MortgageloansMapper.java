package ir.dotin.bigdata.project.mabnaapirestful.mapper.MortgageLoans;

import ir.dotin.bigdata.project.mabnaapirestful.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.broker.response.mortgageLoans.MortgageLoansResponse;
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
