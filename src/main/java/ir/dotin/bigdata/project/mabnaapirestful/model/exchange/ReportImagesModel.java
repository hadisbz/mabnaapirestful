package ir.dotin.bigdata.project.mabnaapirestful.model.exchange;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.MetaResponse;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.ReportsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.MetaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(schema = "public", name = "report_images")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportImagesModel implements Serializable {
    @Id
    private String id;

    @Column(name = "report_id")
    private String reportId;

    @Column(name ="content_type")
    private String contentType;

    @Column(name ="content_length")
    private Long contentLength;

    @Embedded
    private MetaModel meta;
}
