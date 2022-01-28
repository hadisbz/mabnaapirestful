package ir.dotin.bigdata.project.mabnaapirestful.mapper.bonds;

import ir.dotin.bigdata.project.mabnaapirestful.api.response.bonds.BondAuthorityTypesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.bonds.BondAuthorityTypesModel;

public class BondAuthorityTypesMapper {
    public static BondAuthorityTypesModel map(BondAuthorityTypesResponse.BondAuthorityTypesResponseInner bondAuthorityTypesResponseInner){
        return new BondAuthorityTypesModel(
                bondAuthorityTypesResponseInner.getId(),
                bondAuthorityTypesResponseInner.getTitle(),
                MetaMapper.map(bondAuthorityTypesResponseInner.getMetaResponse())
        );
    }
}
