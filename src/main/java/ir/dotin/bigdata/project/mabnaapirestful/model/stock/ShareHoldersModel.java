package ir.dotin.bigdata.project.mabnaapirestful.model.stock;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "local_id")
    private Long localId;

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