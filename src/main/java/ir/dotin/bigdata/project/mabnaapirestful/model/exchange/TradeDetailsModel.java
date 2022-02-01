package ir.dotin.bigdata.project.mabnaapirestful.model.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.model.MetaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "trade_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TradeDetailsModel {
   @Id
   private String id;

   @Column(name="trade_id")
    private String tradeId;

   @Column(name="instrument_id")
    private String instrumentId;

    @Column(name="date_time")
    private String dateTime;

    @Column(name="person_buyer_count")
    private Long personBuyerCount;

    @Column(name="company_buyer_count")
    private Long companyBuyerCount;

    @Column(name="person_buy_volume")
    private Long personBuyVolume;

    @Column(name="company_buy_volume")
    private Long companyBuyVolume;

    @Column(name="person_seller_count")
    private Long personSellerCount;

    @Column(name="company_seller_count")
    private Long companySellerCount;

    @Column(name="person_sell_volume")
    private Long personSellVolume;

    @Column(name="company_sell_volume")
    private Long companySellVolume;

    @Embedded
    private MetaModel mata;
}
