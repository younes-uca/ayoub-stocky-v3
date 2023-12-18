package  ma.zs.easystock.ws.converter.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.easystock.zynerator.util.ListUtil;

import ma.zs.easystock.ws.converter.commun.ClientConverter;
import ma.zs.easystock.ws.converter.stock.ProduitConverter;
import ma.zs.easystock.ws.converter.stock.DevisItemConverter;
import ma.zs.easystock.ws.converter.stock.TaxeConverter;



import ma.zs.easystock.zynerator.util.StringUtil;
import ma.zs.easystock.zynerator.converter.AbstractConverter;
import ma.zs.easystock.zynerator.util.DateUtil;
import ma.zs.easystock.bean.core.stock.Devis;
import ma.zs.easystock.ws.dto.stock.DevisDto;

@Component
public class DevisConverter extends AbstractConverter<Devis, DevisDto> {

    @Autowired
    private ClientConverter clientConverter ;
    @Autowired
    private ProduitConverter produitConverter ;
    @Autowired
    private DevisItemConverter devisItemConverter ;
    @Autowired
    private TaxeConverter taxeConverter ;
    private boolean client;
    private boolean devisItems;

    public  DevisConverter(){//Client clientProduit produitDevisItem devisItemTaxe taxe,){
        super(Devis.class, DevisDto.class);
        init(true);
        //this.client =  client ;
        //this.produit =  produit ;
        //this.devisItem =  devisItem ;
        //this.taxe =  taxe ;
    }

    @Override
    public Devis toItem(DevisDto dto) {
        if (dto == null) {
            return null;
        } else {
        Devis item = new Devis();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getNumero()))
                item.setNumero(dto.getNumero());
            if(StringUtil.isNotEmpty(dto.getDateDevis()))
                item.setDateDevis(DateUtil.stringEnToDate(dto.getDateDevis()));
            if(StringUtil.isNotEmpty(dto.getMontantHt()))
                item.setMontantHt(dto.getMontantHt());
            if(StringUtil.isNotEmpty(dto.getMontantTva()))
                item.setMontantTva(dto.getMontantTva());
            if(StringUtil.isNotEmpty(dto.getMontantTtc()))
                item.setMontantTtc(dto.getMontantTtc());
            if(StringUtil.isNotEmpty(dto.getDescription()))
                item.setDescription(dto.getDescription());
            if(this.client && dto.getClient()!=null &&  dto.getClient().getId() != null)
                item.setClient(clientConverter.toItem(dto.getClient())) ;


            if(this.devisItems && ListUtil.isNotEmpty(dto.getDevisItems()))
                item.setDevisItems(devisItemConverter.toItem(dto.getDevisItems()));


        return item;
        }
    }

    @Override
    public DevisDto toDto(Devis item) {
        if (item == null) {
            return null;
        } else {
            DevisDto dto = new DevisDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getNumero()))
                dto.setNumero(item.getNumero());
            if(item.getDateDevis()!=null)
                dto.setDateDevis(DateUtil.dateTimeToString(item.getDateDevis()));
            if(StringUtil.isNotEmpty(item.getMontantHt()))
                dto.setMontantHt(item.getMontantHt());
            if(StringUtil.isNotEmpty(item.getMontantTva()))
                dto.setMontantTva(item.getMontantTva());
            if(StringUtil.isNotEmpty(item.getMontantTtc()))
                dto.setMontantTtc(item.getMontantTtc());
            if(StringUtil.isNotEmpty(item.getDescription()))
                dto.setDescription(item.getDescription());
        if(this.client && item.getClient()!=null) {
            dto.setClient(clientConverter.toDto(item.getClient())) ;
        }
        if(this.devisItems && ListUtil.isNotEmpty(item.getDevisItems())){
            devisItemConverter.init(true);
            devisItemConverter.setDevis(false);
            dto.setDevisItems(devisItemConverter.toDto(item.getDevisItems()));
            devisItemConverter.setDevis(true);

        }


        return dto;
        }
    }

    public void initList(boolean value) {
        this.devisItems = value;
    }

    public void initObject(boolean value) {
        this.client = value;
    }


    public ClientConverter getClientConverter(){
        return this.clientConverter;
    }
    public void setClientConverter(ClientConverter clientConverter ){
        this.clientConverter = clientConverter;
    }
    public ProduitConverter getProduitConverter(){
        return this.produitConverter;
    }
    public void setProduitConverter(ProduitConverter produitConverter ){
        this.produitConverter = produitConverter;
    }
    public DevisItemConverter getDevisItemConverter(){
        return this.devisItemConverter;
    }
    public void setDevisItemConverter(DevisItemConverter devisItemConverter ){
        this.devisItemConverter = devisItemConverter;
    }
    public TaxeConverter getTaxeConverter(){
        return this.taxeConverter;
    }
    public void setTaxeConverter(TaxeConverter taxeConverter ){
        this.taxeConverter = taxeConverter;
    }
    public boolean  isClient(){
        return this.client;
    }
    public void  setClient(boolean client){
        this.client = client;
    }
    public boolean  isDevisItems(){
        return this.devisItems ;
    }
    public void  setDevisItems(boolean devisItems ){
        this.devisItems  = devisItems ;
    }
}
