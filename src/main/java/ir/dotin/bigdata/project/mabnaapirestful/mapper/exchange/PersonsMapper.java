package ir.dotin.bigdata.project.mabnaapirestful.mapper.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.broker.response.exchange.PersonsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.PersonsModel;

public class PersonsMapper {
    public static PersonsModel map(PersonsResponse.PersonsResponseInner personsResponseInner){

        String genderTypeId=null;
        String genderTypeMetaType=null;

        if(personsResponseInner.getGenderType()!=null){
            genderTypeId = personsResponseInner.getGenderType().getId();
            genderTypeMetaType = personsResponseInner.getGenderType().getMetaResponse().getType();
        }
        return new PersonsModel(
                personsResponseInner.getId(),
                personsResponseInner.getFirstName(),
                personsResponseInner.getEnglishFirstName(),
                personsResponseInner.getLastLame(),
                personsResponseInner.getEnglishLastName(),
                personsResponseInner.getFatherName(),
                personsResponseInner.getEnglishFatherName(),
                genderTypeId,
                genderTypeMetaType,
                personsResponseInner.getBirthDate(),
                personsResponseInner.getIdentificationNo(),
                personsResponseInner.getNationalCode(),
                personsResponseInner.getBiography(),
                personsResponseInner.getEnglishBiography(),
                personsResponseInner.getComments(),
                personsResponseInner.getEnglishComments(),
                personsResponseInner.getEmail(),
                personsResponseInner.getEducation(),
                personsResponseInner.getEnglishEducation(),
                MetaMapper.map(personsResponseInner.getMetaResponse())
        );
    }
}
