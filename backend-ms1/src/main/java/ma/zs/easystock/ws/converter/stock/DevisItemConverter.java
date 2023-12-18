package  ma.zs.easystock.ws.converter.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.easystock.ws.converter.stock.DevisConverter;
import ma.zs.easystock.ws.converter.stock.ProduitConverter;
import ma.zs.easystock.ws.converter.stock.TaxeConverter;

import ma.zs.easystock.bean.core.stock.Produit;
import ma.zs.easystock.bean.core.stock.Devis;


import ma.zs.easystock.zynerator.util.StringUtil;
import ma.zs.easystock.zynerator.converter.AbstractConverter;
import ma.zs.easystock.zynerator.util.DateUtil;
import ma.zs.easystock.bean.core.stock.DevisItem;
import ma.zs.easystock.ws.dto.stock.DevisItemDto;

@Component
public class DevisItemConverter extends AbstractConverter<DevisItem, DevisItemDto> {

    @Autowired
    private DevisConverter devisConverter ;
    @Autowired
    private ProduitConverter produitConverter ;
    @Autowired
    private TaxeConverter taxeConverter ;
    private boolean produit;
    private boolean taxe;
    private boolean devis;

    public  DevisItemConverter(){//Devis devisProduit produitTaxe taxe,){
        super(DevisItem.class, DevisItemDto.class);
        //this.devis =  devis ;
        //this.produit =  produit ;
        //this.taxe =  taxe ;
    }

    @Override
    public DevisItem toItem(DevisItemDto dto) {
        if (dto == null) {
            return null;
        } else {
        DevisItem item = new DevisItem();
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

            if(dto.getDevis() != null && dto.getDevis().getId() != null){
                item.setDevis(new Devis());
                item.getDevis().setId(dto.getDevis().getId());
                item.getDevis().setNumero(dto.getDevis().getNumero());
            }




        return item;
        }
    }

    @Override
    public DevisItemDto toDto(DevisItem item) {
        if (item == null) {
            return null;
        } else {
            DevisItemDto dto = new DevisItemDto();
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
        if(this.devis && item.getDevis()!=null) {
            dto.setDevis(devisConverter.toDto(item.getDevis())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.produit = value;
        this.taxe = value;
        this.devis = value;
    }


    public DevisConverter getDevisConverter(){
        return this.devisConverter;
    }
    public void setDevisConverter(DevisConverter devisConverter ){
        this.devisConverter = devisConverter;
    }
    public ProduitConverter getProduitConverter(){
        return this.produitConverter;
    }
    public void setProduitConverter(ProduitConverter produitConverter ){
        this.produitConverter = produitConverter;
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
    public boolean  isDevis(){
        return this.devis;
    }
    public void  setDevis(boolean devis){
        this.devis = devis;
    }
}
