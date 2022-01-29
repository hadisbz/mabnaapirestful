package ir.dotin.bigdata.project.mabnaapirestful.model.broker.response.exchange;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.model.broker.response.MetaResponse;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class PersonsResponse {
    @JsonProperty("data")
    private List<PersonsResponseInner> data;

    @Getter
    @ToString
    public static class PersonsResponseInner {
        private String id;

        @JsonProperty("first_name")
        private String firstName;

        @JsonProperty("english_first_name")
        private  String englishFirstName;

        @JsonProperty("last_name")
        private String lastLame;

        @JsonProperty("english_last_name")
        private String englishLastName;

        @JsonProperty("father_name")
        private String fatherName;

        @JsonProperty("english_father_name")
        private String englishFatherName;

        @JsonProperty("gender_type")
        private GenderTypesResponse.GenderTypesResponseInner genderType;

        @JsonProperty("birth_date")
        private String birthDate;

        @JsonProperty("identification_no")
        private String identificationNo;

        @JsonProperty("national_code")
        private String nationalCode;

        private String biography;

        @JsonProperty("english_biography")
        private String englishBiography;

        private String comments;

        @JsonProperty("english_comments")
        private String englishComments;

        private String email;

        private String education;

        @JsonProperty("english_education")
        private String englishEducation;

        @JsonProperty("meta")
        private MetaResponse metaResponse;
    }

}
