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
    private String id;

    @Column(name = "index_id")
    private String indexId;

    private String date;

    private Double value;

    private Long volume;

    @Column(name = "trade_count")
    private Long tradeCount;

    @Column(name = "buyer_count")
    private Long buyerCount;

    @Column(name= "advance_trade_count")
    private  Long advanceTradeCount;

    @Column(name = "decline_trade_count")
    private Long declineTradeCount;

    @Embedded
    private MetaModel metaModel;
}
