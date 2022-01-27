package ir.dotin.bigdata.project.mabnaapirestful.model.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.model.MetaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "assets")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssetsModel {
    @Id
    private String id;

    @Column(name="asset_type_id")
    private String assetTypeId;

    @Column(name="trade_symbol")
    private String tradeSymbol;

    @Column(name="english_trade_symbol")
    private String englishTradeSymbol;

    private String name;

    @Column(name="english_name")
    private String englishName;

    @Column(name="short_name")
    private String shortName;

    @Column(name="english_short_name")
    private String englishShortName;

    @Column(name="exchange_id")
    private String exchangeId;

    @Column(name="asset_state_id")
    private String assetStateId;

    @Column(name="company_id")
    private String companyId;


    @Column(name="fund_id")
    private String fundId;

    @Column(name="mortgage_loan_id")
    private String mortgageLoanId;

    @Column(name="fingilish_name")
    private String fingilishName;

    @Column(name="fingilish_short_name")
    private String fingilishShortName;

    @Column(name="fingilish_trade_symbol")
    private  String fingilishTradeSymbol;

    @Column(name="state_change_date")
    private String stateChangeDate;

    @Column(name="state_description")
    private String stateDescription;

    @Column(name="english_state_description")
    private String englishStateDescription;

    @Column(name="entity_id")
    private String entityId;

    @Column(name="entity_type")
    private String entityType;

    @Embedded
    private MetaModel meta;

}
