package ir.dotin.bigdata.project.mabnaapirestful.mapper.bonds;

import ir.dotin.bigdata.project.mabnaapirestful.api.response.bonds.BondsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.bonds.BondsModel;

public class BondsMapper {
    public static BondsModel map(BondsResponse.BondsResponseInner bondResponse){
        Integer paymentIntervalMounths=null;
        String bondUnderwritingTypeId=null;
        String bondUnderwritingTypeMetaType=null;
        String  bondCouponTypeId=null;
        String bondCouponTypeMetaType=null;
        String typeId=null;
        String typeMetaType=null;
        String exchangeId=null;
        String guarantorName=null;
        String certificateTypeId=null;
        String certificateTypeMetaType=null;
        String publisherName=null;

        if(bondResponse.getPaymentInterval()!=null)
            paymentIntervalMounths=bondResponse.getPaymentInterval().getMonths();

        if(bondResponse.getBondUnderwritingType()!=null){
            bondUnderwritingTypeId=bondResponse.getBondUnderwritingType().getId();
            bondUnderwritingTypeMetaType = bondResponse.getBondUnderwritingType().getMetaResponse().getType();
        }

        if(bondResponse.getBondCouponType()!=null){
            bondCouponTypeId=bondResponse.getBondCouponType().getId();
            bondCouponTypeMetaType=bondResponse.getBondCouponType().getMetaResponse().getType();
        }

        if(bondResponse.getType()!=null){
            typeId=bondResponse.getType().getId();
            typeMetaType = bondResponse.getType().getMetaResponse().getType();
        }

        if(bondResponse.getExchange()!=null)
            exchangeId = bondResponse.getExchange().getId();

        if(bondResponse.getCertificateType()!=null){
            certificateTypeId=bondResponse.getCertificateType().getId();
            certificateTypeMetaType=bondResponse.getCertificateType().getMetaResponse().getType();
        }

        if(bondResponse.getGuarantor()!=null)
            guarantorName=bondResponse.getGuarantor().getName();

        if(bondResponse.getPublisher()!=null)
            publisherName=bondResponse.getPublisher().getName();

        return new BondsModel(
                bondResponse.getId(),
                bondResponse.getName(),
                bondResponse.getShortName(),
                bondResponse.getIssueDate(),
                bondResponse.getMatureDate(),
                bondResponse.getUnderwritingStartDate(),
                bondResponse.getUnderwritingEndDate(),
                bondResponse.getNominalPrice(),
                bondResponse.getInterestRate(),
                paymentIntervalMounths,
                bondResponse.getDescription(),
                bondResponse.getTotalBonds(),
                bondResponse.getTradeSymbol(),
                bondResponse.getEnglisheTradeSymbol(),
                bondResponse.getCategoryCode(),
                bondResponse.getAdjustedRate(),
                bondResponse.getLegislationDescription(),
                bondResponse.getMinistryApprovalDescription(),
                bondResponse.getGuarantyDescription(),
                bondResponse.getCertificateAuthority(),
                bondUnderwritingTypeId,
                bondUnderwritingTypeMetaType,
                bondCouponTypeId,
                bondCouponTypeMetaType,
                typeId,
                typeMetaType,
                exchangeId,
                publisherName,
                guarantorName,
                certificateTypeId,
                certificateTypeMetaType,
                MetaMapper.map(bondResponse.getMetaResponse())

        );




    }
}
