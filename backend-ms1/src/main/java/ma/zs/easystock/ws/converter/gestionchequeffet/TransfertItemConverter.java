package  ma.zs.easystock.ws.converter.gestionchequeffet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.easystock.ws.converter.commun.DepotConverter;
import ma.zs.easystock.ws.converter.stock.ProduitConverter;
import ma.zs.easystock.ws.converter.gestionchequeffet.TransfertConverter;

import ma.zs.easystock.bean.core.stock.Produit;
import ma.zs.easystock.bean.core.gestionchequeffet.Transfert;


import ma.zs.easystock.zynerator.util.StringUtil;
import ma.zs.easystock.zynerator.converter.AbstractConverter;
import ma.zs.easystock.zynerator.util.DateUtil;
import ma.zs.easystock.bean.core.gestionchequeffet.TransfertItem;
import ma.zs.easystock.ws.dto.gestionchequeffet.TransfertItemDto;

@Component
public class TransfertItemConverter extends AbstractConverter<TransfertItem, TransfertItemDto> {

    @Autowired
    private DepotConverter depotConverter ;
    @Autowired
    private ProduitConverter produitConverter ;
    @Autowired
    private TransfertConverter transfertConverter ;
    private boolean depot;
    private boolean produit;
    private boolean transfert;

    public  TransfertItemConverter(){//Depot depotProduit produitTransfert transfert,){
        super(TransfertItem.class, TransfertItemDto.class);
        //this.depot =  depot ;
        //this.produit =  produit ;
        //this.transfert =  transfert ;
    }

    @Override
    public TransfertItem toItem(TransfertItemDto dto) {
        if (dto == null) {
            return null;
        } else {
        TransfertItem item = new TransfertItem();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getQuantite()))
                item.setQuantite(dto.getQuantite());
            if(this.depot && dto.getDepot()!=null &&  dto.getDepot().getId() != null)
                item.setDepot(depotConverter.toItem(dto.getDepot())) ;

            if(dto.getProduit() != null && dto.getProduit().getId() != null){
                item.setProduit(new Produit());
                item.getProduit().setId(dto.getProduit().getId());
                item.getProduit().setDesignation(dto.getProduit().getDesignation());
            }

            if(dto.getTransfert() != null && dto.getTransfert().getId() != null){
                item.setTransfert(new Transfert());
                item.getTransfert().setId(dto.getTransfert().getId());
                item.getTransfert().setId(dto.getTransfert().getId());
            }




        return item;
        }
    }

    @Override
    public TransfertItemDto toDto(TransfertItem item) {
        if (item == null) {
            return null;
        } else {
            TransfertItemDto dto = new TransfertItemDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getQuantite()))
                dto.setQuantite(item.getQuantite());
        if(this.depot && item.getDepot()!=null) {
            dto.setDepot(depotConverter.toDto(item.getDepot())) ;
        }
        if(this.produit && item.getProduit()!=null) {
            dto.setProduit(produitConverter.toDto(item.getProduit())) ;
        }
        if(this.transfert && item.getTransfert()!=null) {
            dto.setTransfert(transfertConverter.toDto(item.getTransfert())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.depot = value;
        this.produit = value;
        this.transfert = value;
    }


    public DepotConverter getDepotConverter(){
        return this.depotConverter;
    }
    public void setDepotConverter(DepotConverter depotConverter ){
        this.depotConverter = depotConverter;
    }
    public ProduitConverter getProduitConverter(){
        return this.produitConverter;
    }
    public void setProduitConverter(ProduitConverter produitConverter ){
        this.produitConverter = produitConverter;
    }
    public TransfertConverter getTransfertConverter(){
        return this.transfertConverter;
    }
    public void setTransfertConverter(TransfertConverter transfertConverter ){
        this.transfertConverter = transfertConverter;
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
    public boolean  isTransfert(){
        return this.transfert;
    }
    public void  setTransfert(boolean transfert){
        this.transfert = transfert;
    }
}
