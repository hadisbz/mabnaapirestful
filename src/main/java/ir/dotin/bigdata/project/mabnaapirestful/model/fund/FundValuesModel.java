package ir.dotin.bigdata.project.mabnaapirestful.model.fund;
import ir.dotin.bigdata.project.mabnaapirestful.model.MetaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Entity
@Table(schema = "public", name = "Fund_Values")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FundValuesModel {
    @Id
    private String id;

    @Column(name="fund_id")
    private String fundID;

    private String date;

    @Column(name = "bid_price")
    private Integer bidPrice;

    @Column(name = "redemption_price")
    private Integer redemptionPrice;

    @Column(name="statistical_price")
    private Integer statisticalPrice;

    @Column(name="bid_count")
    private Integer bidCount;

    @Column(name="redemption_count")
    private Integer redemptionCount;

    private Long nav;

    private Long units;

    @Embedded
    private MetaModel meta;
}

