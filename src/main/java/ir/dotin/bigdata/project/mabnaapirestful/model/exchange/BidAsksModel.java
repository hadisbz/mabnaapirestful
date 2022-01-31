package ir.dotin.bigdata.project.mabnaapirestful.model.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.model.MetaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "bid_asks")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class BidAsksModel {
    @Id
    private String id;

    @Column(name="instrument_id")
    private String instrumentId;

    @Column(name="date_time")
    private String dateTime;

    @Column(name="order_rank")
    private Long orderRank;

    @Column(name="ask_count")
    private Long askCount;

    @Column(name="ask_order")
    private Long askOrder;

    @Column(name="ask_volume")
    private Long askVolume;

    @Column(name="ask_price")
    private Double askPrice;

    @Column(name="bid_order")
    private Long bidOrder;

    @Column(name="bid_volume")
    private Long bidVolume;

    @Column(name="bid_price")
    private Double bidPrice;

    @Embedded
    private MetaModel meta;

}
