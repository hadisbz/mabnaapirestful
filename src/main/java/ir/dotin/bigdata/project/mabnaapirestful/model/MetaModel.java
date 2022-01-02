package ir.dotin.bigdata.project.mabnaapirestful.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MetaModel {
    @Column(name = "meta_type")
    private String type;

    @Column(name = "meta_version")
    private Long version;

    @Column(name = "meta_state")
    private String state;

    @Column(name = "meta_insert_date_time")
    private String insertDateTime;

    @Column(name = "meta_update_date_time")
    private String updateDateTime;

    @Column(name = "meta_delete_date_time")
    private String deleteDateTime;
}
