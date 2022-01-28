package ir.dotin.bigdata.project.mabnaapirestful.model.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.model.MetaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(schema = "public", name = "market_messages")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarketMessagesModel {
    @Id
    private String id;

    @Column(name = "date_time")
    private String dateTime;

    private String title;

    private String text;

    @Embedded
    private MetaModel meta;
}
