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
public class AnnouncementTypeModel {
    @Column(name="announcement_type_id")
    private String announcementTypeID;

    @Column(name="announcement_type_title")
    private String announcementTypeTitle;

    @Column(name="announcement_type_english_title")
    private String announcementTypeEnglishTitle;

    @Column(name="announcement_type_meta_type")
    private String announcementTypeMetaType;

    @Column(name = "announcement_type_meta_version")
    private Long announcementTypeMetaVersion;

    @Column(name = "announcement_type_meta_state")
    private String announcementTypeMetaState;

    @Column(name = "announcement_type_meta_insert_date_time")
    private String announcementTypeMetaInsertDateTime;

    @Column(name = "announcement_type_meta_update_date_time")
    private String announcementTypeMetaUpdateDateTime;

    @Column(name = "announcement_type_meta_delete_date_time")
    private String announcementTypeMetaDeleteDateTime;


}
