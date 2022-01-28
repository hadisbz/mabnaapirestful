package ir.dotin.bigdata.project.mabnaapirestful.model.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.model.MetaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "trades")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TradesModel {
    @Id
    private String id;

    @Column(name="instrument_id")
    private String instrumentId;

    @Column(name="date_time")
    private String dateTime;

    @Column(name="open_price")
    private Double openPrice;

    @Column(name="high_price")
    private Double highPrice;

    @Column(name="low_price")
    private Double lowPrice;

    @Column(name="real_close_price")
    private Double realClosePrice;

    @Column(name="real_close_price_change")
    private Double realClosePriceChange;

    @Column(name="close_price")
    private Double closePrice;

    @Column(name="close_price_change")
    private Double closePriceChange;

    @Column(name="buyer_count")
    private Integer buyerCount;

    private Long volume;

    private Double value;

    @Column(name="trade_count")
    private Integer tradeCount;

    @Column(name="adjusted_close_price")
    private Double adjustedClosePrice;

    @Embedded
    private MetaModel meta;


}
