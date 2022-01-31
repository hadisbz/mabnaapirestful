package ir.dotin.bigdata.project.mabnaapirestful.mapper;

import ir.dotin.bigdata.project.mabnaapirestful.api.response.ProductionSaleTypeResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.ProductionSaleTypeModel;

public class ProductionSaleTypeMapper {
    public static ProductionSaleTypeModel map(ProductionSaleTypeResponse productionSaleTypeResponse){
        return new ProductionSaleTypeModel(
                productionSaleTypeResponse.getId(),
                productionSaleTypeResponse.getTitle(),
                productionSaleTypeResponse.getEnglishTitle(),
                productionSaleTypeResponse.getMetaResponse().getType(),
                productionSaleTypeResponse.getMetaResponse().getVersion(),
                productionSaleTypeResponse.getMetaResponse().getState(),
                productionSaleTypeResponse.getMetaResponse().getInsertDateTime(),
                productionSaleTypeResponse.getMetaResponse().getUpdateDateTime(),
                productionSaleTypeResponse.getMetaResponse().getDeleteDateTime()

        );

    }
}
