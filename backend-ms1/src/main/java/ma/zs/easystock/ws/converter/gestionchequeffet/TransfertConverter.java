package  ma.zs.easystock.ws.converter.gestionchequeffet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.easystock.zynerator.util.ListUtil;

import ma.zs.easystock.ws.converter.commun.DepotConverter;
import ma.zs.easystock.ws.converter.gestionchequeffet.TransfertItemConverter;
import ma.zs.easystock.ws.converter.stock.ProduitConverter;
import ma.zs.easystock.ws.converter.Transfert.RaisonConverter;



import ma.zs.easystock.zynerator.util.StringUtil;
import ma.zs.easystock.zynerator.converter.AbstractConverter;
import ma.zs.easystock.zynerator.util.DateUtil;
import ma.zs.easystock.bean.core.gestionchequeffet.Transfert;
import ma.zs.easystock.ws.dto.gestionchequeffet.TransfertDto;

@Component
public class TransfertConverter extends AbstractConverter<Transfert, TransfertDto> {

    @Autowired
    private DepotConverter depotConverter ;
    @Autowired
    private TransfertItemConverter transfertItemConverter ;
    @Autowired
    private ProduitConverter produitConverter ;
    @Autowired
    private RaisonConverter raisonConverter ;
    private boolean raison;
    private boolean transfertItems;

    public  TransfertConverter(){//Depot depotTransfertItem transfertItemProduit produitRaison raison){
        super(Transfert.class, TransfertDto.class);
        init(true);
        //this.depot =  depot ;
        //this.transfertItem =  transfertItem ;
        //this.produit =  produit ;
        //this.raison =  raison ;
    }

    @Override
    public Transfert toItem(TransfertDto dto) {
        if (dto == null) {
            return null;
        } else {
        Transfert item = new Transfert();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getReference()))
                item.setReference(dto.getReference());
            if(StringUtil.isNotEmpty(dto.getDateTransfert()))
                item.setDateTransfert(DateUtil.stringEnToDate(dto.getDateTransfert()));
            if(StringUtil.isNotEmpty(dto.getDescription()))
                item.setDescription(dto.getDescription());
            if(this.raison && dto.getRaison()!=null &&  dto.getRaison().getId() != null)
                item.setRaison(raisonConverter.toItem(dto.getRaison())) ;


            if(this.transfertItems && ListUtil.isNotEmpty(dto.getTransfertItems()))
                item.setTransfertItems(transfertItemConverter.toItem(dto.getTransfertItems()));


        return item;
        }
    }

    @Override
    public TransfertDto toDto(Transfert item) {
        if (item == null) {
            return null;
        } else {
            TransfertDto dto = new TransfertDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getReference()))
                dto.setReference(item.getReference());
            if(item.getDateTransfert()!=null)
                dto.setDateTransfert(DateUtil.dateTimeToString(item.getDateTransfert()));
            if(StringUtil.isNotEmpty(item.getDescription()))
                dto.setDescription(item.getDescription());
        if(this.raison && item.getRaison()!=null) {
            dto.setRaison(raisonConverter.toDto(item.getRaison())) ;
        }
        if(this.transfertItems && ListUtil.isNotEmpty(item.getTransfertItems())){
            transfertItemConverter.init(true);
            transfertItemConverter.setTransfert(false);
            dto.setTransfertItems(transfertItemConverter.toDto(item.getTransfertItems()));
            transfertItemConverter.setTransfert(true);

        }


        return dto;
        }
    }

    public void initList(boolean value) {
        this.transfertItems = value;
    }

    public void initObject(boolean value) {
        this.raison = value;
    }


    public DepotConverter getDepotConverter(){
        return this.depotConverter;
    }
    public void setDepotConverter(DepotConverter depotConverter ){
        this.depotConverter = depotConverter;
    }
    public TransfertItemConverter getTransfertItemConverter(){
        return this.transfertItemConverter;
    }
    public void setTransfertItemConverter(TransfertItemConverter transfertItemConverter ){
        this.transfertItemConverter = transfertItemConverter;
    }
    public ProduitConverter getProduitConverter(){
        return this.produitConverter;
    }
    public void setProduitConverter(ProduitConverter produitConverter ){
        this.produitConverter = produitConverter;
    }
    public RaisonConverter getRaisonConverter(){
        return this.raisonConverter;
    }
    public void setRaisonConverter(RaisonConverter raisonConverter ){
        this.raisonConverter = raisonConverter;
    }
    public boolean  isRaison(){
        return this.raison;
    }
    public void  setRaison(boolean raison){
        this.raison = raison;
    }
    public boolean  isTransfertItems(){
        return this.transfertItems ;
    }
    public void  setTransfertItems(boolean transfertItems ){
        this.transfertItems  = transfertItems ;
    }
}
