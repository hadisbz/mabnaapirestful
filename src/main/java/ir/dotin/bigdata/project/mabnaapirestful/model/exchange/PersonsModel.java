package ir.dotin.bigdata.project.mabnaapirestful.model.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.model.MetaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "persons")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "local_id")
    private Long localId;

    private String id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "english_first_name")
    private String englishFirstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "english_last_name")
    private String englishLastName;

    @Column(name = "father_name")
    private String fatherName;

    @Column(name = "english_father_name")
    private String englishFatherName;

    @Column(name = "gender_type")
    private String genderType;

    @Column(name = "birth_date")
    private String birthDate;

    @Column(name = "identification_no")
    private String identificationNo;

    @Column(name = "national_code")
    private String nationalCode;

    private String biography;

    @Column(name = "english_biography")
    private String englishBiography;

    private String comments;

    @Column(name = "english_comments")
    private String englishComments;

    private String email;

    private String education;

    @Column(name="english_education")
    private String englishEducation;

    @Embedded
    private MetaModel meta;

}
