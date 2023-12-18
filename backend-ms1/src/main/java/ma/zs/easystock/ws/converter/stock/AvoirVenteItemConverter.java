package  ma.zs.easystock.ws.converter.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.easystock.ws.converter.commun.DepotConverter;
import ma.zs.easystock.ws.converter.stock.AvoirVenteConverter;
import ma.zs.easystock.ws.converter.stock.ProduitConverter;
import ma.zs.easystock.ws.converter.stock.TaxeConverter;

import ma.zs.easystock.bean.core.stock.Produit;
import ma.zs.easystock.bean.core.stock.AvoirVente;


import ma.zs.easystock.zynerator.util.StringUtil;
import ma.zs.easystock.zynerator.converter.AbstractConverter;
import ma.zs.easystock.zynerator.util.DateUtil;
import ma.zs.easystock.bean.core.stock.AvoirVenteItem;
import ma.zs.easystock.ws.dto.stock.AvoirVenteItemDto;

@Component
public class AvoirVenteItemConverter extends AbstractConverter<AvoirVenteItem, AvoirVenteItemDto> {

    @Autowired
    private DepotConverter depotConverter ;
    @Autowired
    private AvoirVenteConverter avoirVenteConverter ;
    @Autowired
    private ProduitConverter produitConverter ;
    @Autowired
    private TaxeConverter taxeConverter ;
    private boolean depot;
    private boolean produit;
    private boolean taxe;
    private boolean avoirVente;

    public  AvoirVenteItemConverter(){//Depot depotAvoirVente avoirVenteProduit produitTaxe taxe,){
        super(AvoirVenteItem.class, AvoirVenteItemDto.class);
        //this.depot =  depot ;
        //this.avoirVente =  avoirVente ;
        //this.produit =  produit ;
        //this.taxe =  taxe ;
    }

    @Override
    public AvoirVenteItem toItem(AvoirVenteItemDto dto) {
        if (dto == null) {
            return null;
        } else {
        AvoirVenteItem item = new AvoirVenteItem();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getBarCode()))
                item.setBarCode(dto.getBarCode());
            if(StringUtil.isNotEmpty(dto.getQuantite()))
                item.setQuantite(dto.getQuantite());
            if(StringUtil.isNotEmpty(dto.getQuantiteAvoir()))
                item.setQuantiteAvoir(dto.getQuantiteAvoir());
            if(StringUtil.isNotEmpty(dto.getQuantiteVendue()))
                item.setQuantiteVendue(dto.getQuantiteVendue());
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
            if(this.depot && dto.getDepot()!=null &&  dto.getDepot().getId() != null)
                item.setDepot(depotConverter.toItem(dto.getDepot())) ;

            if(dto.getProduit() != null && dto.getProduit().getId() != null){
                item.setProduit(new Produit());
                item.getProduit().setId(dto.getProduit().getId());
                item.getProduit().setDesignation(dto.getProduit().getDesignation());
            }

            if(this.taxe && dto.getTaxe()!=null &&  dto.getTaxe().getId() != null)
                item.setTaxe(taxeConverter.toItem(dto.getTaxe())) ;

            if(dto.getAvoirVente() != null && dto.getAvoirVente().getId() != null){
                item.setAvoirVente(new AvoirVente());
                item.getAvoirVente().setId(dto.getAvoirVente().getId());
                item.getAvoirVente().setNumeroFactureAvoirVente(dto.getAvoirVente().getNumeroFactureAvoirVente());
            }




        return item;
        }
    }

    @Override
    public AvoirVenteItemDto toDto(AvoirVenteItem item) {
        if (item == null) {
            return null;
        } else {
            AvoirVenteItemDto dto = new AvoirVenteItemDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getBarCode()))
                dto.setBarCode(item.getBarCode());
            if(StringUtil.isNotEmpty(item.getQuantite()))
                dto.setQuantite(item.getQuantite());
            if(StringUtil.isNotEmpty(item.getQuantiteAvoir()))
                dto.setQuantiteAvoir(item.getQuantiteAvoir());
            if(StringUtil.isNotEmpty(item.getQuantiteVendue()))
                dto.setQuantiteVendue(item.getQuantiteVendue());
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
        if(this.depot && item.getDepot()!=null) {
            dto.setDepot(depotConverter.toDto(item.getDepot())) ;
        }
        if(this.produit && item.getProduit()!=null) {
            dto.setProduit(produitConverter.toDto(item.getProduit())) ;
        }
        if(this.taxe && item.getTaxe()!=null) {
            dto.setTaxe(taxeConverter.toDto(item.getTaxe())) ;
        }
        if(this.avoirVente && item.getAvoirVente()!=null) {
            dto.setAvoirVente(avoirVenteConverter.toDto(item.getAvoirVente())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.depot = value;
        this.produit = value;
        this.taxe = value;
        this.avoirVente = value;
    }


    public DepotConverter getDepotConverter(){
        return this.depotConverter;
    }
    public void setDepotConverter(DepotConverter depotConverter ){
        this.depotConverter = depotConverter;
    }
    public AvoirVenteConverter getAvoirVenteConverter(){
        return this.avoirVenteConverter;
    }
    public void setAvoirVenteConverter(AvoirVenteConverter avoirVenteConverter ){
        this.avoirVenteConverter = avoirVenteConverter;
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
    public boolean  isDepot(){
        return this.depot;
    }
    public void  setDepot(boolean depot){
        this.depot = depot;
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
    public boolean  isAvoirVente(){
        return this.avoirVente;
    }
    public void  setAvoirVente(boolean avoirVente){
        this.avoirVente = avoirVente;
    }
}
