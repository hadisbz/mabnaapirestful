package ir.dotin.bigdata.project.mabnaapirestful.model.stock;

import ir.dotin.bigdata.project.mabnaapirestful.model.MetaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Entity
@Table(schema = "public", name = "companies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompaniesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "local_id")
    private Long localId;

    private String id;

    private String name;

    @Column(name = "english_name")
    private String englishName;

    @Column(name = "short_name")
    private String shortName;

    @Column(name = "english_short_name")
    private String englishShortName;

    @Column(name = "trade_symbol")
    private String tradeSymbol;

    @Column(name = "englishTradeSymbol")
    private String fingilishShortName;

    private String description;

    private String fiscalyear;

    @Column(name="state_id")
    private String stateId;

    @Column(name="exchange_id")
    private String exchangeId;

    @Embedded
    private MetaModel meta;

}
