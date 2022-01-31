package ir.dotin.bigdata.project.mabnaapirestful.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductionSaleTypeModel {
    @Column(name="production_sale_type_id")
    private String productionSaleTypeID;

    @Column(name="production_sale_type_title")
    private String productionSaleTypeTitle;

    @Column(name="production_sale_type_english_title")
    private String productionSaleTypeEnglishTitle;

    @Column(name="production_sale_type_meta_type")
    private String productionSaleTypeMetaType;

    @Column(name = "production_sale_type_meta_version")
    private Long productionSaleTypeMetaVersion;

    @Column(name = "production_sale_type_meta_state")
    private String productionSaleTypeMetaState;

    @Column(name = "production_sale_type_meta_insert_date_time")
    private String productionSaleTypeMetaInsertDateTime;

    @Column(name = "production_sale_type_meta_update_date_time")
    private String productionSaleTypeMetaUpdateDateTime;

    @Column(name = "production_sale_type_meta_delete_date_time")
    private String productionSaleTypeMetaDeleteDateTime;

}
