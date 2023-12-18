package  ma.zs.easystock.ws.converter.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.easystock.ws.converter.stock.ProduitConverter;
import ma.zs.easystock.ws.converter.entree.EntreeProduitConverter;

import ma.zs.easystock.bean.core.stock.Produit;
import ma.zs.easystock.bean.core.entree.EntreeProduit;


import ma.zs.easystock.zynerator.util.StringUtil;
import ma.zs.easystock.zynerator.converter.AbstractConverter;
import ma.zs.easystock.zynerator.util.DateUtil;
import ma.zs.easystock.bean.core.stock.EntreeProduitItem;
import ma.zs.easystock.ws.dto.stock.EntreeProduitItemDto;

@Component
public class EntreeProduitItemConverter extends AbstractConverter<EntreeProduitItem, EntreeProduitItemDto> {

    @Autowired
    private ProduitConverter produitConverter ;
    @Autowired
    private EntreeProduitConverter entreeProduitConverter ;
    private boolean produit;
    private boolean entreeProduit;

    public  EntreeProduitItemConverter(){//Produit produitEntreeProduit entreeProduit,){
        super(EntreeProduitItem.class, EntreeProduitItemDto.class);
        //this.produit =  produit ;
        //this.entreeProduit =  entreeProduit ;
    }

    @Override
    public EntreeProduitItem toItem(EntreeProduitItemDto dto) {
        if (dto == null) {
            return null;
        } else {
        EntreeProduitItem item = new EntreeProduitItem();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getQuantite()))
                item.setQuantite(dto.getQuantite());
            if(StringUtil.isNotEmpty(dto.getDescription()))
                item.setDescription(dto.getDescription());
            if(dto.getProduit() != null && dto.getProduit().getId() != null){
                item.setProduit(new Produit());
                item.getProduit().setId(dto.getProduit().getId());
                item.getProduit().setDesignation(dto.getProduit().getDesignation());
            }

            if(dto.getEntreeProduit() != null && dto.getEntreeProduit().getId() != null){
                item.setEntreeProduit(new EntreeProduit());
                item.getEntreeProduit().setId(dto.getEntreeProduit().getId());
                item.getEntreeProduit().setReference(dto.getEntreeProduit().getReference());
            }




        return item;
        }
    }

    @Override
    public EntreeProduitItemDto toDto(EntreeProduitItem item) {
        if (item == null) {
            return null;
        } else {
            EntreeProduitItemDto dto = new EntreeProduitItemDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getQuantite()))
                dto.setQuantite(item.getQuantite());
            if(StringUtil.isNotEmpty(item.getDescription()))
                dto.setDescription(item.getDescription());
        if(this.produit && item.getProduit()!=null) {
            dto.setProduit(produitConverter.toDto(item.getProduit())) ;
        }
        if(this.entreeProduit && item.getEntreeProduit()!=null) {
            dto.setEntreeProduit(entreeProduitConverter.toDto(item.getEntreeProduit())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.produit = value;
        this.entreeProduit = value;
    }


    public ProduitConverter getProduitConverter(){
        return this.produitConverter;
    }
    public void setProduitConverter(ProduitConverter produitConverter ){
        this.produitConverter = produitConverter;
    }
    public EntreeProduitConverter getEntreeProduitConverter(){
        return this.entreeProduitConverter;
    }
    public void setEntreeProduitConverter(EntreeProduitConverter entreeProduitConverter ){
        this.entreeProduitConverter = entreeProduitConverter;
    }
    public boolean  isProduit(){
        return this.produit;
    }
    public void  setProduit(boolean produit){
        this.produit = produit;
    }
    public boolean  isEntreeProduit(){
        return this.entreeProduit;
    }
    public void  setEntreeProduit(boolean entreeProduit){
        this.entreeProduit = entreeProduit;
    }
}
