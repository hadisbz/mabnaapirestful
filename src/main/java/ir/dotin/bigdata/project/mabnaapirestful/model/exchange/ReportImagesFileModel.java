package ir.dotin.bigdata.project.mabnaapirestful.model.exchange;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(schema = "public", name = "report_images_file")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportImagesFileModel implements Serializable {
    @Id
    private String id;

    @Lob
    @Type(type = "org.hibernate.type.BinaryType")
    private byte[] content;
}
