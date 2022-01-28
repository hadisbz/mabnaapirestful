package ir.dotin.bigdata.project.mabnaapirestful.model.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.model.MetaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "report_sources")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportSourcesModel {
    @Id
    private String id;

    private String title;

    @Embedded
    private MetaModel meta;
}
