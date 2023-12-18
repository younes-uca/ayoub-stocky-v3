package  ma.zs.easystock.ws.converter.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.easystock.ws.converter.entree.SortieProduitConverter;
import ma.zs.easystock.ws.converter.stock.ProduitConverter;

import ma.zs.easystock.bean.core.stock.Produit;
import ma.zs.easystock.bean.core.entree.SortieProduit;


import ma.zs.easystock.zynerator.util.StringUtil;
import ma.zs.easystock.zynerator.converter.AbstractConverter;
import ma.zs.easystock.zynerator.util.DateUtil;
import ma.zs.easystock.bean.core.stock.SortieProduitItem;
import ma.zs.easystock.ws.dto.stock.SortieProduitItemDto;

@Component
public class SortieProduitItemConverter extends AbstractConverter<SortieProduitItem, SortieProduitItemDto> {

    @Autowired
    private SortieProduitConverter sortieProduitConverter ;
    @Autowired
    private ProduitConverter produitConverter ;
    private boolean produit;
    private boolean sortieProduit;

    public  SortieProduitItemConverter(){//SortieProduit sortieProduitProduit produit,){
        super(SortieProduitItem.class, SortieProduitItemDto.class);
        //this.sortieProduit =  sortieProduit ;
        //this.produit =  produit ;
    }

    @Override
    public SortieProduitItem toItem(SortieProduitItemDto dto) {
        if (dto == null) {
            return null;
        } else {
        SortieProduitItem item = new SortieProduitItem();
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

            if(dto.getSortieProduit() != null && dto.getSortieProduit().getId() != null){
                item.setSortieProduit(new SortieProduit());
                item.getSortieProduit().setId(dto.getSortieProduit().getId());
                item.getSortieProduit().setReference(dto.getSortieProduit().getReference());
            }




        return item;
        }
    }

    @Override
    public SortieProduitItemDto toDto(SortieProduitItem item) {
        if (item == null) {
            return null;
        } else {
            SortieProduitItemDto dto = new SortieProduitItemDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getQuantite()))
                dto.setQuantite(item.getQuantite());
            if(StringUtil.isNotEmpty(item.getDescription()))
                dto.setDescription(item.getDescription());
        if(this.produit && item.getProduit()!=null) {
            dto.setProduit(produitConverter.toDto(item.getProduit())) ;
        }
        if(this.sortieProduit && item.getSortieProduit()!=null) {
            dto.setSortieProduit(sortieProduitConverter.toDto(item.getSortieProduit())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.produit = value;
        this.sortieProduit = value;
    }


    public SortieProduitConverter getSortieProduitConverter(){
        return this.sortieProduitConverter;
    }
    public void setSortieProduitConverter(SortieProduitConverter sortieProduitConverter ){
        this.sortieProduitConverter = sortieProduitConverter;
    }
    public ProduitConverter getProduitConverter(){
        return this.produitConverter;
    }
    public void setProduitConverter(ProduitConverter produitConverter ){
        this.produitConverter = produitConverter;
    }
    public boolean  isProduit(){
        return this.produit;
    }
    public void  setProduit(boolean produit){
        this.produit = produit;
    }
    public boolean  isSortieProduit(){
        return this.sortieProduit;
    }
    public void  setSortieProduit(boolean sortieProduit){
        this.sortieProduit = sortieProduit;
    }
}
