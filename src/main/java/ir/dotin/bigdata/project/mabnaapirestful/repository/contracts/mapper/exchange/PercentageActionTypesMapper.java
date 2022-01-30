package ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.PercentageActionTypesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.PercentageActionTypesModel;

public class PercentageActionTypesMapper {
    public static PercentageActionTypesModel map(PercentageActionTypesResponse.PercentageActionTypesResponseInner percentageActionTypesResponseInner) {
        return new PercentageActionTypesModel(
                percentageActionTypesResponseInner.getId(),
                percentageActionTypesResponseInner.getTitle(),
                percentageActionTypesResponseInner.getEnglishTitle(),
                MetaMapper.map(percentageActionTypesResponseInner.getMetaResponse())
        );
    }
}
