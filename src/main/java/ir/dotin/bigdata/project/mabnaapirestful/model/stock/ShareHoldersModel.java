package ir.dotin.bigdata.project.mabnaapirestful.model.stock;

import ir.dotin.bigdata.project.mabnaapirestful.model.MetaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "share_holders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShareHoldersModel {
    @Id
    private String id;

    private String date;

    @Column(name="company_id")
    private String companyId;

    @Column(name="report_id")
    private String reportId;

    private String comments;

    @Column(name="english_comments")
    private String englishComments;

    @Embedded
    private MetaModel meta;

}
