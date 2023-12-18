package  ma.zs.easystock.ws.converter.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.easystock.ws.converter.stock.ProduitConverter;
import ma.zs.easystock.ws.converter.stock.CommandeConverter;
import ma.zs.easystock.ws.converter.stock.TaxeConverter;

import ma.zs.easystock.bean.core.stock.Produit;
import ma.zs.easystock.bean.core.stock.Commande;


import ma.zs.easystock.zynerator.util.StringUtil;
import ma.zs.easystock.zynerator.converter.AbstractConverter;
import ma.zs.easystock.zynerator.util.DateUtil;
import ma.zs.easystock.bean.core.stock.CommandeItem;
import ma.zs.easystock.ws.dto.stock.CommandeItemDto;

@Component
public class CommandeItemConverter extends AbstractConverter<CommandeItem, CommandeItemDto> {

    @Autowired
    private ProduitConverter produitConverter ;
    @Autowired
    private CommandeConverter commandeConverter ;
    @Autowired
    private TaxeConverter taxeConverter ;
    private boolean produit;
    private boolean taxe;
    private boolean commande;

    public  CommandeItemConverter(){//Produit produitCommande commandeTaxe taxe,){
        super(CommandeItem.class, CommandeItemDto.class);
        //this.produit =  produit ;
        //this.commande =  commande ;
        //this.taxe =  taxe ;
    }

    @Override
    public CommandeItem toItem(CommandeItemDto dto) {
        if (dto == null) {
            return null;
        } else {
        CommandeItem item = new CommandeItem();
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

            if(dto.getCommande() != null && dto.getCommande().getId() != null){
                item.setCommande(new Commande());
                item.getCommande().setId(dto.getCommande().getId());
                item.getCommande().setNumeroCommande(dto.getCommande().getNumeroCommande());
            }




        return item;
        }
    }

    @Override
    public CommandeItemDto toDto(CommandeItem item) {
        if (item == null) {
            return null;
        } else {
            CommandeItemDto dto = new CommandeItemDto();
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
        if(this.commande && item.getCommande()!=null) {
            dto.setCommande(commandeConverter.toDto(item.getCommande())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.produit = value;
        this.taxe = value;
        this.commande = value;
    }


    public ProduitConverter getProduitConverter(){
        return this.produitConverter;
    }
    public void setProduitConverter(ProduitConverter produitConverter ){
        this.produitConverter = produitConverter;
    }
    public CommandeConverter getCommandeConverter(){
        return this.commandeConverter;
    }
    public void setCommandeConverter(CommandeConverter commandeConverter ){
        this.commandeConverter = commandeConverter;
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
    public boolean  isCommande(){
        return this.commande;
    }
    public void  setCommande(boolean commande){
        this.commande = commande;
    }
}
