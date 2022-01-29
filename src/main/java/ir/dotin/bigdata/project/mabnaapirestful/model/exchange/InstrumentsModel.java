package ir.dotin.bigdata.project.mabnaapirestful.model.exchange;


import ir.dotin.bigdata.project.mabnaapirestful.model.MetaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "instruments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstrumentsModel {
    @Id
    private String id;

    private String code;

    @Column(name="bbs_code")
    private String bbsCode;

    private String isin;

    private String name;

    @Column(name="english_name")
    private String englishName;

    @Column(name="short_name")
    private String shortName;

    @Column(name="english_short_name")
    private String englishShortName;

    private String type;

    @Column(name="exchange_id")
    private String exchangeId;

    @Column(name="market_id")
    private String marketId;

    @Column(name= "board_id")
    private String boardId;

    @Column(name="group_id")
    private String groupId;

    @Column(name="value_type")
    private String valueType;

    @Column(name="base_volume")
    private Long baseVolume;

    @Column(name="nominal_price")
    private Double nominalPrice;

    @Column(name="price_tick")
    private Long priceTick;

    @Column(name="trade_tick")
    private Long tradeTick;

    @Column(name="payment_delay")
    private Long paymentDelay;

    @Column(name="minimum_volume_permit")
    private Long minimumVolumePermit;

    @Column(name="maximum_volume_permit")
    private Long maximumVolumePermit;

    @Column(name="exchange_state_id")
    private String exchangeStateId;

    @Column(name="company_id")
    private String companyId;

    @Column(name="option.contract_id")
    private String optionContractId;

    @Column(name="index_id")
    private String indexId;

    @Column(name="asset_id")
    private String assetId;

    @Column(name="main_instrument_id")
    private String mainInstrumentId;

    @Column(name="main_instrument_type")
    private String mainInstrumenType;

    @Column(name="parent_instrument_id")
    private String parentInstrumentId;

    @Column(name="parent_instrument_type")
    private String parentInstrumentType;

    @Column(name="listing_date")
    private String listingDate;

    @Column(name="share_count")
    private Long shareCount;

    @Embedded
    private MetaModel meta;


}
