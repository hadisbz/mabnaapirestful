package ir.dotin.bigdata.project.mabnaapirestful.mapper.stock;

import ir.dotin.bigdata.project.mabnaapirestful.model.api.response.stock.ProductsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.stock.ProductsModel;

public class ProductsMapper {
    public static ProductsModel map(ProductsResponse.ProductsResponseInner ProductsResponseInner){
        return new ProductsModel(
                null,
                ProductsResponseInner.getId(),
                ProductsResponseInner.getTitle(),
                ProductsResponseInner.getEnglishTitle(),
                MetaMapper.map(ProductsResponseInner.getMetaResponse())
        );
    }
}
