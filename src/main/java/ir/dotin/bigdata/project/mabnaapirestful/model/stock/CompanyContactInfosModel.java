package ir.dotin.bigdata.project.mabnaapirestful.model.stock;

import ir.dotin.bigdata.project.mabnaapirestful.model.MetaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "company_contact_infos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyContactInfosModel {
    @Id
    private String id;

    @Column(name="company_id")
    private String companyId;

    @Column(name="company_contact_info_types_response_id")
    private String CompanyContactInfoTypesResponseId;

    private String title;

    @Column(name = "english_title")
    private String englishTitle;

    private String address;

    @Column(name="english_address")
    private String englishAddress;

    private String telephone;

    private String fax;

    private String email;

    private String website;

    private String comments;

    @Column(name="english_comments")
    private String englishComments;

    @Column(name="po_box")
    private  String poBox;

    @Column(name="postal_code")
    private String postalCode;

    @Embedded
    private MetaModel meta;


}
