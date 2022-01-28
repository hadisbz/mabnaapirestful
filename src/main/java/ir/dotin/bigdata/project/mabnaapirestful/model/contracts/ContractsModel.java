package ir.dotin.bigdata.project.mabnaapirestful.model.contracts;

import ir.dotin.bigdata.project.mabnaapirestful.model.MetaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Entity
@Table(schema = "public", name = "contracts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContractsModel {
    @Id
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

    @Column(name = "english_trade_symbol")
    private String englishTradeSymbol;

    @Column(name="exchange_id")
    private String exchangeId;

    @Column(name="publisher_company_id")
    private String publisherCompanyId;

    @Column(name="trade_start_date")
    private String tradeStartDate;

    @Column(name="trade_end_date")
    private String tradeEndDate;

    @Column(name = "exercise_date")
    private String exerciseDate;

    @Column(name="exercise_price")
    private Double exercisePrice;

    @Column(name="type_id")
    private String typeId;

    @Column(name="style_id")
    private String styleId;

    @Column(name="entity_id")
    private String entityId;

    @Embedded
    private MetaModel meta;
}
