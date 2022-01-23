package ir.dotin.bigdata.project.mabnaapirestful.model.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.model.MetaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "index_trade_summaries")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IndexTradeSummariesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "local_id")
    private Long localId;

    private String id;

    @Column(name = "index_id")
    private String indexId;

    private String date;

    private Double value;

    private Long volume;

    @Column(name = "trade_count")
    private Integer tradeCount;

    @Column(name = "buyer_count")
    private Integer buyerCount;

    @Column(name= "advance_trade_count")
    private  Integer advanceTradeCount;

    @Column(name = "decline_trade_count")
    private Integer declineTradeCount;

    @Embedded
    private MetaModel metaModel;
}
