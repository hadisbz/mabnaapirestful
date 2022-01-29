package ir.dotin.bigdata.project.mabnaapirestful.model.stock;

import ir.dotin.bigdata.project.mabnaapirestful.model.MetaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "balancesheet_fields")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BalancesheetFieldsModel {
    @Id
    private String id;

    private String title;

    @Column(name = "english_title")
    private String englishTitle;

    private String account;

    private Long index;

    @Embedded
    private MetaModel meta;

}
