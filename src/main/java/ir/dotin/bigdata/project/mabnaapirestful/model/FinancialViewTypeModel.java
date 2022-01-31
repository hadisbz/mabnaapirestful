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
public class FinancialViewTypeModel {
    @Column(name="financial_view_type_id")
    private String financialViewTypeID;

    @Column(name="financial_view_type_title")
    private String financialViewTypeTitle;

    @Column(name="financial_view_type_english_title")
    private String financialViewTypeEnglishTitle;

    @Column(name="financial_view_type_meta_type")
    private String financialViewTypeMetaType;

    @Column(name = "financial_view_type_meta_version")
    private Long financialViewTypeMetaVersion;

    @Column(name = "financial_view_type_meta_state")
    private String financialViewTypeMetaState;

    @Column(name = "financial_view_type_meta_insert_date_time")
    private String financialViewTypeMetaInsertDateTime;

    @Column(name = "financial_view_type_meta_update_date_time")
    private String financialViewTypeMetaUpdateDateTime;

    @Column(name = "financial_view_type_meta_delete_date_time")
    private String financialViewTypeMetaDeleteDateTime;
}
