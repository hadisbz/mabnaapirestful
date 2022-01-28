package ir.dotin.bigdata.project.mabnaapirestful.model.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.model.MetaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "initial_public_offerings")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InitialPublicOfferingsModel {
    @Id
    private String id;

    @Column(name="instrument_id")
    private String instrumentId;

    @Column(name="instrument_type")
    private String instrumentType;

    @Column(name="start_date_time")
    private String startDateTime;

    @Column(name="end_date_time")
    private String endDateTime;

    @Column(name="min_price_permit")
    private Double minPricePermit;

    @Column(name="max_price_permit")
    private Double maxPricePermit;

    @Column(name="min_volume_permit")
    private Long minVolumePermit;

    @Column(name="max_volume_permit")
    private Long maxVolumePermit;

    @Column(name="start_trading_date")
    private String startTradingDate;

    @Column(name="allotment_date")
    private String allotmentDate;

    @Embedded
    private MetaModel meta;
    
}
