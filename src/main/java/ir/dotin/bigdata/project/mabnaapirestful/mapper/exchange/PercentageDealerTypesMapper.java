package ir.dotin.bigdata.project.mabnaapirestful.mapper.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.PercentageDealerTypesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.PercentageDealerTypesModel;

public class PercentageDealerTypesMapper {
    public static PercentageDealerTypesModel map(PercentageDealerTypesResponse.PercentageDealerTypesResponseInner percentageDealerTypesResponseInner) {
        return new PercentageDealerTypesModel(
                percentageDealerTypesResponseInner.getId(),
                percentageDealerTypesResponseInner.getTitle(),
                percentageDealerTypesResponseInner.getEnglishTitle(),
                MetaMapper.map(percentageDealerTypesResponseInner.getMetaResponse())
        );
    }
}
