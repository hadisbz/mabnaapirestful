package ir.dotin.bigdata.project.mabnaapirestful.model.bonds;

import ir.dotin.bigdata.project.mabnaapirestful.model.MetaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "bonds")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BondsModel {
    @Id
    private String id;

    private String name;

    @Column(name="short_name")
    private String shortName;

    @Column(name="issue_date")
    private String issueDate;

    @Column(name="mature_date")
    private String matureDate;

    @Column(name="underwriting_start_date")
    private String underwritingStartDate;

    @Column(name="underwriting_end_date")
    private String underwritingEndDate;

    @Column(name="nominal_price")
    private Double nominalPrice;

    @Column(name="interest_rate")
    private Double interestRate;

    @Column(name="payment_interval_mounths")
    private Integer paymentIntervalMounths;

    private String description;

    @Column(name="total_bonds")
    private Long totalBonds;

    @Column(name="trade_symbol")
    private String tradeSymbol;

    @Column(name="englishTradeSymbol")
    private String englishTradeSymbol;

    @Column(name="category_code")
    private String categoryCode;

    @Column(name="adjusted_rate")
    private Double adjustedRate;

    @Column(name="legislation_description")
    private String legislationDescription;

    @Column(name="ministry_approval_description")
    private String ministryApprovalDescription;

    @Column(name="guaranty_description")
    private String guarantyDescription;

    @Column(name="certificate_authority")
    private String certificateAuthority;

    @Column(name="bond_underwriting_type_id")
    private String bondUnderwritingTypeId;

    @Column(name="bond_underwriting_type_meta_type")
    private String bondUnderwritingTypeMetaType;


    @Column(name="bond_coupon_type_id")
    private String  bondCouponTypeId;

    @Column(name="bond_coupon_type_Meta_type")
    private String bondCouponTypeMetaType;

    @Column(name="type_id")
    private String typeId;

    @Column(name="type_Meta_type")
    private String typeMetaType;

    @Column(name="exchange_id")
    private String exchangeId;

    @Column(name="publisher_name")
    private String publisherName;

    @Column(name="guarantor_name")
    private String guarantorName;

    @Column(name="certificate_type_id")
    private String certificateTypeId;

    @Column(name="certificate_type_meta_type")
    private String certificateTypeMetaType;

    @Embedded
    private MetaModel meta;

}
