package  ma.zs.easystock.ws.converter.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.easystock.ws.converter.stock.ProduitConverter;
import ma.zs.easystock.ws.converter.stock.BonPourConverter;
import ma.zs.easystock.ws.converter.stock.TaxeConverter;

import ma.zs.easystock.bean.core.stock.Produit;
import ma.zs.easystock.bean.core.stock.BonPour;


import ma.zs.easystock.zynerator.util.StringUtil;
import ma.zs.easystock.zynerator.converter.AbstractConverter;
import ma.zs.easystock.zynerator.util.DateUtil;
import ma.zs.easystock.bean.core.stock.BonPourItem;
import ma.zs.easystock.ws.dto.stock.BonPourItemDto;

@Component
public class BonPourItemConverter extends AbstractConverter<BonPourItem, BonPourItemDto> {

    @Autowired
    private ProduitConverter produitConverter ;
    @Autowired
    private BonPourConverter bonPourConverter ;
    @Autowired
    private TaxeConverter taxeConverter ;
    private boolean produit;
    private boolean taxe;
    private boolean bonPour;

    public  BonPourItemConverter(){//Produit produitBonPour bonPourTaxe taxe,){
        super(BonPourItem.class, BonPourItemDto.class);
        //this.produit =  produit ;
        //this.bonPour =  bonPour ;
        //this.taxe =  taxe ;
    }

    @Override
    public BonPourItem toItem(BonPourItemDto dto) {
        if (dto == null) {
            return null;
        } else {
        BonPourItem item = new BonPourItem();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getQuantite()))
                item.setQuantite(dto.getQuantite());
            if(StringUtil.isNotEmpty(dto.getPrixUnitaireHt()))
                item.setPrixUnitaireHt(dto.getPrixUnitaireHt());
            if(StringUtil.isNotEmpty(dto.getPrixUnitaireTtc()))
                item.setPrixUnitaireTtc(dto.getPrixUnitaireTtc());
            if(StringUtil.isNotEmpty(dto.getRemise()))
                item.setRemise(dto.getRemise());
            if(StringUtil.isNotEmpty(dto.getMontantHt()))
                item.setMontantHt(dto.getMontantHt());
            if(StringUtil.isNotEmpty(dto.getMontantTtc()))
                item.setMontantTtc(dto.getMontantTtc());
            if(dto.getProduit() != null && dto.getProduit().getId() != null){
                item.setProduit(new Produit());
                item.getProduit().setId(dto.getProduit().getId());
                item.getProduit().setDesignation(dto.getProduit().getDesignation());
            }

            if(this.taxe && dto.getTaxe()!=null &&  dto.getTaxe().getId() != null)
                item.setTaxe(taxeConverter.toItem(dto.getTaxe())) ;

            if(dto.getBonPour() != null && dto.getBonPour().getId() != null){
                item.setBonPour(new BonPour());
                item.getBonPour().setId(dto.getBonPour().getId());
                item.getBonPour().setNumero(dto.getBonPour().getNumero());
            }




        return item;
        }
    }

    @Override
    public BonPourItemDto toDto(BonPourItem item) {
        if (item == null) {
            return null;
        } else {
            BonPourItemDto dto = new BonPourItemDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getQuantite()))
                dto.setQuantite(item.getQuantite());
            if(StringUtil.isNotEmpty(item.getPrixUnitaireHt()))
                dto.setPrixUnitaireHt(item.getPrixUnitaireHt());
            if(StringUtil.isNotEmpty(item.getPrixUnitaireTtc()))
                dto.setPrixUnitaireTtc(item.getPrixUnitaireTtc());
            if(StringUtil.isNotEmpty(item.getRemise()))
                dto.setRemise(item.getRemise());
            if(StringUtil.isNotEmpty(item.getMontantHt()))
                dto.setMontantHt(item.getMontantHt());
            if(StringUtil.isNotEmpty(item.getMontantTtc()))
                dto.setMontantTtc(item.getMontantTtc());
        if(this.produit && item.getProduit()!=null) {
            dto.setProduit(produitConverter.toDto(item.getProduit())) ;
        }
        if(this.taxe && item.getTaxe()!=null) {
            dto.setTaxe(taxeConverter.toDto(item.getTaxe())) ;
        }
        if(this.bonPour && item.getBonPour()!=null) {
            dto.setBonPour(bonPourConverter.toDto(item.getBonPour())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.produit = value;
        this.taxe = value;
        this.bonPour = value;
    }


    public ProduitConverter getProduitConverter(){
        return this.produitConverter;
    }
    public void setProduitConverter(ProduitConverter produitConverter ){
        this.produitConverter = produitConverter;
    }
    public BonPourConverter getBonPourConverter(){
        return this.bonPourConverter;
    }
    public void setBonPourConverter(BonPourConverter bonPourConverter ){
        this.bonPourConverter = bonPourConverter;
    }
    public TaxeConverter getTaxeConverter(){
        return this.taxeConverter;
    }
    public void setTaxeConverter(TaxeConverter taxeConverter ){
        this.taxeConverter = taxeConverter;
    }
    public boolean  isProduit(){
        return this.produit;
    }
    public void  setProduit(boolean produit){
        this.produit = produit;
    }
    public boolean  isTaxe(){
        return this.taxe;
    }
    public void  setTaxe(boolean taxe){
        this.taxe = taxe;
    }
    public boolean  isBonPour(){
        return this.bonPour;
    }
    public void  setBonPour(boolean bonPour){
        this.bonPour = bonPour;
    }
}
