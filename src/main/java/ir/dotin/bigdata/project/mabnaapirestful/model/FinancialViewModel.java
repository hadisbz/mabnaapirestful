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
public class FinancialViewModel {
    @Column(name="financial_view_type_id")
    private String financialViewTypeID;

    @Column(name="financial_view_type_title")
    private String financialViewTypeTitle;

    @Column(name="financial_view_type_english_title")
    private String financialViewTypeEnglishTitle;

    @Column(name="financial_view_type_meta_type")
    private String financialViewTypeMetaType;
}
