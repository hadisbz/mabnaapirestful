package ir.dotin.bigdata.project.mabnaapirestful.model.stock;

import ir.dotin.bigdata.project.mabnaapirestful.model.MetaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "company_categories")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyCategoriesModel {
    @Id
    private String id;

    @Column(name="company_id")
    private String companyId;

    @Column(name="category_id")
    private String categoryId;

    @Embedded
    private MetaModel meta;
}
