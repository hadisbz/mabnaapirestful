package ir.dotin.bigdata.project.mabnaapirestful.model.broker;

import ir.dotin.bigdata.project.mabnaapirestful.model.MetaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Entity
@Table(schema = "public", name = "brokers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BrokersModel {
    @Id
    private String id;

    private String code;

    private String name;

    @Column(name = "english_name")
    private String englishName;

    @Column(name = "short_name")
    private String shortName;

    @Column(name = "english_short_name")
    private String englishShortName;

   @Column(name="parent_id")
    private String parentID;

   @Column(name="parent_type")
   private String parentType;

    @Column(name="bic_code")
    private String bicCode;

    @Column(name="trade_code")
    private String tradeCode;

    @Column(name="nsc_code")
    private String nscCode;

    @Embedded
    private MetaModel meta;
}
