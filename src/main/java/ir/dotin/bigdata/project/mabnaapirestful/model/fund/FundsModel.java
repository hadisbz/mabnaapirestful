package ir.dotin.bigdata.project.mabnaapirestful.model.fund;

import ir.dotin.bigdata.project.mabnaapirestful.model.MetaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "funds")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class FundsModel {
    @Id
    private String id;

    private String code;

    private String name;

    @Column(name="english_name")
    private String englishName;

    @Column(name = "short_name")
    private String shortName;

    @Column(name = "english_short_name")
    private String englishShortName;

    private String website;

    @Column(name = "trade_symbol")
    private String tradeSymbol;

    @Column(name = "english_trade_symbol")
    private String englishTradeSymbol;

    @Column(name = "inception_date")
    private String inceptionDate;

    @Column(name = "manager_name")
    private String managerName;

    @Column(name = "manager_english_name")
    private String managerEnglishName;

    @Column(name="investment_manager_name")
    private String investmentManagerName;

    @Column(name="investment_manager_english_name")
    private String investmentManagerEnglishName;

    @Column(name="custodian_name")
    private String custodianName;

    @Column(name="custodian_english_name")
    private String custodianEnglishName;


    @Column(name = "liquidity_guarantor_name")
    private String liquidityGuarantorName;

    @Column(name = "liquidity_guarantor_english_name")
    private String liquidityGuarantorEnglishName;

    @Column(name= "auditor_name")
    private String auditorName;

    @Column(name= "auditor_english_name")
    private String auditorEnglishName;

    @Column(name="registration_manager_name")
    private String registrationManagerName;

    @Column(name="registration_manager_english_name")
    private String registrationManagerEnglihName;


    @Column(name="instrument_exchange_states_id")
    private String instrumentExchangeStatesId;

    @Column(name="exchange_id")
    private String exchangeId;

    @Embedded
    private MetaModel meta;

}
