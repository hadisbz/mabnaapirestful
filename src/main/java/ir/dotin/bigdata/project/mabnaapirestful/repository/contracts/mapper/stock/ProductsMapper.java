package ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.stock;

import ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.stock.ProductsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.stock.ProductsModel;

public class ProductsMapper {
    public static ProductsModel map(ProductsResponse.ProductsResponseInner ProductsResponseInner){
        return new ProductsModel(
                ProductsResponseInner.getId(),
                ProductsResponseInner.getTitle(),
                ProductsResponseInner.getEnglishTitle(),
                MetaMapper.map(ProductsResponseInner.getMetaResponse())
        );
    }
}
