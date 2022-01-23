package ir.dotin.bigdata.project.mabnaapirestful.model.stock;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.stock.CompaniesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.stock.CompanyContactInfoTypesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.MetaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(schema = "public", name = "company_contact_infos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyContactInfosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "local_id")
    private Long localId;

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
