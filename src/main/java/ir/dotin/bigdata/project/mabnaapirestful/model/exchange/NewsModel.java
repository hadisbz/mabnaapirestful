package ir.dotin.bigdata.project.mabnaapirestful.model.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.model.MetaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "news")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class NewsModel {
    @Id
    private String id;

    private String sourceId;

    private String entityId;

    private String entityType;

    public String date;

    public String title;

    public String text;

    @Embedded
    private MetaModel meta;
}
