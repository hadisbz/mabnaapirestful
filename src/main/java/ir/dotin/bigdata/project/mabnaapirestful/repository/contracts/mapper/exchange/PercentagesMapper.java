package ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.PercentagesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.PercentagesModel;

public class PercentagesMapper {
    public static PercentagesModel map(PercentagesResponse.PercentagesResponseInner percentagesResponseInner) {
        return new PercentagesModel(
                percentagesResponseInner.getId(),
                percentagesResponseInner.getTitle(),
                percentagesResponseInner.getEnglishTitle(),
                MetaMapper.map(percentagesResponseInner.getMetaResponse())
        );
    }
}
