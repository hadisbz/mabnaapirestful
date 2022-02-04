package ir.dotin.bigdata.project.mabnaapirestful.model.exchange;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.model.MetaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "intraday_trades")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IntradayTradesModel {
    @Id
    private String id;

    @Column(name="trade_id")
    private String tradeId;

    @Column(name="instrument_id")
    private String instrumentId;

    @Column(name="date_time")
    private String dateTime;

    @Column(name="close_price")
    private Double closePrice;

    @Column(name="real_close_price")
    private Double realClosePrice;

    private Long volume;

    private Double value;

    @Column(name="trade_count")
    private Long tradeCount;

    @Column(name="open_price")
    private Double openPrice;

    @Column(name="low_price")
    private  Double lowPrice;

    @Column(name="high_price")
    private Double highPrice;

    @Embedded
    private MetaModel meta;
}
