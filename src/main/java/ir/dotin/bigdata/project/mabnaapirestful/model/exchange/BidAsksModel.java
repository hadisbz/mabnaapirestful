package ir.dotin.bigdata.project.mabnaapirestful.model.exchange;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    private Integer orderRank;

    @Column(name="ask_count")
    private Integer askCount;

    @Column(name="ask_order")
    private Integer askOrder;

    @Column(name="ask_volume")
    private Integer askVolume;

    @Column(name="ask_price")
    private Double askPrice;

    @Column(name="bid_order")
    private Integer bidOrder;

    @Column(name="bid_volume")
    private Integer bidVolume;

    @Column(name="bid_price")
    private Double bidPrice;

    @Embedded
    private MetaModel meta;

}