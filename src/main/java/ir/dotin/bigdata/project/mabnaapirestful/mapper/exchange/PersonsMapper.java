package ir.dotin.bigdata.project.mabnaapirestful.mapper.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.PersonsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.PersonsModel;

public class PersonsMapper {
    public static PersonsModel map(PersonsResponse.PersonsResponseInner PersonsResponseInner){
        return new PersonsModel(
                null,
                PersonsResponseInner.getId(),
                PersonsResponseInner.getFirstName(),
                PersonsResponseInner.getEnglishFirstName(),
                PersonsResponseInner.getLastLame(),
                PersonsResponseInner.getEnglishLastName(),
                PersonsResponseInner.getFatherName(),
                PersonsResponseInner.getEnglishFatherName(),
                PersonsResponseInner.getGenderType(),
                PersonsResponseInner.getBirthDate(),
                PersonsResponseInner.getIdentificationNo(),
                PersonsResponseInner.getNationalCode(),
                PersonsResponseInner.getBiography(),
                PersonsResponseInner.getEnglishBiography(),
                PersonsResponseInner.getComments(),
                PersonsResponseInner.getEnglishComments(),
                PersonsResponseInner.getEmail(),
                PersonsResponseInner.getEducation(),
                PersonsResponseInner.getEnglishEducation(),
                MetaMapper.map(PersonsResponseInner.getMetaResponse())
        );
    }
}
