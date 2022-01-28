package ir.dotin.bigdata.project.mabnaapirestful.model.stock;

import ir.dotin.bigdata.project.mabnaapirestful.model.MetaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Entity
@Table(schema = "public", name = "meeting_types")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MeetingTypesModel {
    @Id
    private String id;

    private String title;

    @Embedded
    private MetaModel meta;
}
