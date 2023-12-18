package  ma.zs.easystock.ws.converter.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.easystock.zynerator.util.ListUtil;

import ma.zs.easystock.ws.converter.commun.ClientConverter;
import ma.zs.easystock.ws.converter.stock.CommandeItemConverter;
import ma.zs.easystock.ws.converter.stock.ProduitConverter;
import ma.zs.easystock.ws.converter.commun.EtatCommandeConverter;
import ma.zs.easystock.ws.converter.stock.TaxeConverter;



import ma.zs.easystock.zynerator.util.StringUtil;
import ma.zs.easystock.zynerator.converter.AbstractConverter;
import ma.zs.easystock.zynerator.util.DateUtil;
import ma.zs.easystock.bean.core.stock.Commande;
import ma.zs.easystock.ws.dto.stock.CommandeDto;

@Component
public class CommandeConverter extends AbstractConverter<Commande, CommandeDto> {

    @Autowired
    private ClientConverter clientConverter ;
    @Autowired
    private CommandeItemConverter commandeItemConverter ;
    @Autowired
    private ProduitConverter produitConverter ;
    @Autowired
    private EtatCommandeConverter etatCommandeConverter ;
    @Autowired
    private TaxeConverter taxeConverter ;
    private boolean client;
    private boolean etatCommande;
    private boolean commandeItems;

    public  CommandeConverter(){//Client clientCommandeItem commandeItemProduit produitEtatCommande etatCommandeTaxe taxe){
        super(Commande.class, CommandeDto.class);
        init(true);
        //this.client =  client ;
        //this.commandeItem =  commandeItem ;
        //this.produit =  produit ;
        //this.etatCommande =  etatCommande ;
        //this.taxe =  taxe ;
    }

    @Override
    public Commande toItem(CommandeDto dto) {
        if (dto == null) {
            return null;
        } else {
        Commande item = new Commande();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getBarCode()))
                item.setBarCode(dto.getBarCode());
            if(StringUtil.isNotEmpty(dto.getNumeroCommande()))
                item.setNumeroCommande(dto.getNumeroCommande());
            if(StringUtil.isNotEmpty(dto.getDateCommande()))
                item.setDateCommande(DateUtil.stringEnToDate(dto.getDateCommande()));
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

            if(this.etatCommande && dto.getEtatCommande()!=null &&  dto.getEtatCommande().getId() != null)
                item.setEtatCommande(etatCommandeConverter.toItem(dto.getEtatCommande())) ;


            if(this.commandeItems && ListUtil.isNotEmpty(dto.getCommandeItems()))
                item.setCommandeItems(commandeItemConverter.toItem(dto.getCommandeItems()));


        return item;
        }
    }

    @Override
    public CommandeDto toDto(Commande item) {
        if (item == null) {
            return null;
        } else {
            CommandeDto dto = new CommandeDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getBarCode()))
                dto.setBarCode(item.getBarCode());
            if(StringUtil.isNotEmpty(item.getNumeroCommande()))
                dto.setNumeroCommande(item.getNumeroCommande());
            if(item.getDateCommande()!=null)
                dto.setDateCommande(DateUtil.dateTimeToString(item.getDateCommande()));
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
        if(this.etatCommande && item.getEtatCommande()!=null) {
            dto.setEtatCommande(etatCommandeConverter.toDto(item.getEtatCommande())) ;
        }
        if(this.commandeItems && ListUtil.isNotEmpty(item.getCommandeItems())){
            commandeItemConverter.init(true);
            commandeItemConverter.setCommande(false);
            dto.setCommandeItems(commandeItemConverter.toDto(item.getCommandeItems()));
            commandeItemConverter.setCommande(true);

        }


        return dto;
        }
    }

    public void initList(boolean value) {
        this.commandeItems = value;
    }

    public void initObject(boolean value) {
        this.client = value;
        this.etatCommande = value;
    }


    public ClientConverter getClientConverter(){
        return this.clientConverter;
    }
    public void setClientConverter(ClientConverter clientConverter ){
        this.clientConverter = clientConverter;
    }
    public CommandeItemConverter getCommandeItemConverter(){
        return this.commandeItemConverter;
    }
    public void setCommandeItemConverter(CommandeItemConverter commandeItemConverter ){
        this.commandeItemConverter = commandeItemConverter;
    }
    public ProduitConverter getProduitConverter(){
        return this.produitConverter;
    }
    public void setProduitConverter(ProduitConverter produitConverter ){
        this.produitConverter = produitConverter;
    }
    public EtatCommandeConverter getEtatCommandeConverter(){
        return this.etatCommandeConverter;
    }
    public void setEtatCommandeConverter(EtatCommandeConverter etatCommandeConverter ){
        this.etatCommandeConverter = etatCommandeConverter;
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
    public boolean  isEtatCommande(){
        return this.etatCommande;
    }
    public void  setEtatCommande(boolean etatCommande){
        this.etatCommande = etatCommande;
    }
    public boolean  isCommandeItems(){
        return this.commandeItems ;
    }
    public void  setCommandeItems(boolean commandeItems ){
        this.commandeItems  = commandeItems ;
    }
}
