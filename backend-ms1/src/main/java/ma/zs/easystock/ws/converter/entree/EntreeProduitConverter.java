package  ma.zs.easystock.ws.converter.entree;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.easystock.zynerator.util.ListUtil;

import ma.zs.easystock.ws.converter.commun.DepotConverter;
import ma.zs.easystock.ws.converter.stock.ProduitConverter;
import ma.zs.easystock.ws.converter.commun.FournisseurConverter;
import ma.zs.easystock.ws.converter.stock.EntreeProduitItemConverter;



import ma.zs.easystock.zynerator.util.StringUtil;
import ma.zs.easystock.zynerator.converter.AbstractConverter;
import ma.zs.easystock.zynerator.util.DateUtil;
import ma.zs.easystock.bean.core.entree.EntreeProduit;
import ma.zs.easystock.ws.dto.entree.EntreeProduitDto;

@Component
public class EntreeProduitConverter extends AbstractConverter<EntreeProduit, EntreeProduitDto> {

    @Autowired
    private DepotConverter depotConverter ;
    @Autowired
    private ProduitConverter produitConverter ;
    @Autowired
    private FournisseurConverter fournisseurConverter ;
    @Autowired
    private EntreeProduitItemConverter entreeProduitItemConverter ;
    private boolean fournisseur;
    private boolean depot;
    private boolean entreeProduitItems;

    public  EntreeProduitConverter(){//Depot depotProduit produitFournisseur fournisseurEntreeProduitItem entreeProduitItem){
        super(EntreeProduit.class, EntreeProduitDto.class);
        init(true);
        //this.depot =  depot ;
        //this.produit =  produit ;
        //this.fournisseur =  fournisseur ;
        //this.entreeProduitItem =  entreeProduitItem ;
    }

    @Override
    public EntreeProduit toItem(EntreeProduitDto dto) {
        if (dto == null) {
            return null;
        } else {
        EntreeProduit item = new EntreeProduit();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getReference()))
                item.setReference(dto.getReference());
            if(StringUtil.isNotEmpty(dto.getDateEntreeProduit()))
                item.setDateEntreeProduit(DateUtil.stringEnToDate(dto.getDateEntreeProduit()));
            if(StringUtil.isNotEmpty(dto.getDescription()))
                item.setDescription(dto.getDescription());
            if(this.fournisseur && dto.getFournisseur()!=null &&  dto.getFournisseur().getId() != null)
                item.setFournisseur(fournisseurConverter.toItem(dto.getFournisseur())) ;

            if(this.depot && dto.getDepot()!=null &&  dto.getDepot().getId() != null)
                item.setDepot(depotConverter.toItem(dto.getDepot())) ;


            if(this.entreeProduitItems && ListUtil.isNotEmpty(dto.getEntreeProduitItems()))
                item.setEntreeProduitItems(entreeProduitItemConverter.toItem(dto.getEntreeProduitItems()));


        return item;
        }
    }

    @Override
    public EntreeProduitDto toDto(EntreeProduit item) {
        if (item == null) {
            return null;
        } else {
            EntreeProduitDto dto = new EntreeProduitDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getReference()))
                dto.setReference(item.getReference());
            if(item.getDateEntreeProduit()!=null)
                dto.setDateEntreeProduit(DateUtil.dateTimeToString(item.getDateEntreeProduit()));
            if(StringUtil.isNotEmpty(item.getDescription()))
                dto.setDescription(item.getDescription());
        if(this.fournisseur && item.getFournisseur()!=null) {
            dto.setFournisseur(fournisseurConverter.toDto(item.getFournisseur())) ;
        }
        if(this.depot && item.getDepot()!=null) {
            dto.setDepot(depotConverter.toDto(item.getDepot())) ;
        }
        if(this.entreeProduitItems && ListUtil.isNotEmpty(item.getEntreeProduitItems())){
            entreeProduitItemConverter.init(true);
            entreeProduitItemConverter.setEntreeProduit(false);
            dto.setEntreeProduitItems(entreeProduitItemConverter.toDto(item.getEntreeProduitItems()));
            entreeProduitItemConverter.setEntreeProduit(true);

        }


        return dto;
        }
    }

    public void initList(boolean value) {
        this.entreeProduitItems = value;
    }

    public void initObject(boolean value) {
        this.fournisseur = value;
        this.depot = value;
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
    public FournisseurConverter getFournisseurConverter(){
        return this.fournisseurConverter;
    }
    public void setFournisseurConverter(FournisseurConverter fournisseurConverter ){
        this.fournisseurConverter = fournisseurConverter;
    }
    public EntreeProduitItemConverter getEntreeProduitItemConverter(){
        return this.entreeProduitItemConverter;
    }
    public void setEntreeProduitItemConverter(EntreeProduitItemConverter entreeProduitItemConverter ){
        this.entreeProduitItemConverter = entreeProduitItemConverter;
    }
    public boolean  isFournisseur(){
        return this.fournisseur;
    }
    public void  setFournisseur(boolean fournisseur){
        this.fournisseur = fournisseur;
    }
    public boolean  isDepot(){
        return this.depot;
    }
    public void  setDepot(boolean depot){
        this.depot = depot;
    }
    public boolean  isEntreeProduitItems(){
        return this.entreeProduitItems ;
    }
    public void  setEntreeProduitItems(boolean entreeProduitItems ){
        this.entreeProduitItems  = entreeProduitItems ;
    }
}
