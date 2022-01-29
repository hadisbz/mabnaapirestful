package ir.dotin.bigdata.project.mabnaapirestful.model.fund;

import ir.dotin.bigdata.project.mabnaapirestful.model.MetaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Entity
@Table(schema = "public", name = "ratings")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RatingsModel {
    @Id
    private String id;

    @Column(name="fund_id")
    private String fundId;

    private String date;

    private Long rating;

    @Column(name="rating_period")
    private Long ratingPeriod;

    @Column(name="credit_rater_id")
    private String creditRaterID;

    @Column(name="credit_rater_type")
    private String creditRaterType;

    @Column(name="publish_date")
    private String publishDate;

    @Embedded
    private MetaModel meta;
}

