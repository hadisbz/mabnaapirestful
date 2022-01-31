package ir.dotin.bigdata.project.mabnaapirestful.mapper.stock;

import ir.dotin.bigdata.project.mabnaapirestful.api.response.stock.ProductionSaleItemsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.ProductionSaleTypeMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.ProductionSaleTypeModel;
import ir.dotin.bigdata.project.mabnaapirestful.model.stock.ProductionSaleItemsModel;

public class ProductionSaleItemsMapper {
    public static ProductionSaleItemsModel map(ProductionSaleItemsResponse.ProductionSaleItemsResponseInner productionSaleItemsResponseInner){
        String productionSaleId=null;
        String productId=null;
        String unitId=null;
        ProductionSaleTypeModel typeModel = null;

        if(productionSaleItemsResponseInner.getProductionSale()!=null)
            productionSaleId=productionSaleItemsResponseInner.getProductionSale().getId();

        if(productionSaleItemsResponseInner.getProduct()!=null)
            productId=productionSaleItemsResponseInner.getProduct().getId();

        if(productionSaleItemsResponseInner.getUnit()!=null)
            unitId=productionSaleItemsResponseInner.getUnit().getId();

        if(productionSaleItemsResponseInner.getType()!=null)
            typeModel= ProductionSaleTypeMapper.map(productionSaleItemsResponseInner.getType());

        return new ProductionSaleItemsModel(
                productionSaleItemsResponseInner.getId(),
                productionSaleId,
                productId,
                unitId,
                productionSaleItemsResponseInner.getProductionCount(),
                productionSaleItemsResponseInner.getSale_count(),
                productionSaleItemsResponseInner.getSaleAmount(),
                typeModel,
                MetaMapper.map(productionSaleItemsResponseInner.getMetaResponse())
        );
    }
}
