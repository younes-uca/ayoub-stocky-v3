package  ma.zs.easystock.ws.converter.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.easystock.zynerator.util.ListUtil;

import ma.zs.easystock.ws.converter.commun.ClientConverter;
import ma.zs.easystock.ws.converter.stock.AvoirVenteItemConverter;
import ma.zs.easystock.ws.converter.commun.DepotConverter;
import ma.zs.easystock.ws.converter.commun.EtatAvoirVenteConverter;
import ma.zs.easystock.ws.converter.stock.ProduitConverter;
import ma.zs.easystock.ws.converter.commun.EntrepriseSocieteConverter;
import ma.zs.easystock.ws.converter.stock.VenteConverter;
import ma.zs.easystock.ws.converter.stock.TaxeConverter;

import ma.zs.easystock.bean.core.stock.Vente;


import ma.zs.easystock.zynerator.util.StringUtil;
import ma.zs.easystock.zynerator.converter.AbstractConverter;
import ma.zs.easystock.zynerator.util.DateUtil;
import ma.zs.easystock.bean.core.stock.AvoirVente;
import ma.zs.easystock.ws.dto.stock.AvoirVenteDto;

@Component
public class AvoirVenteConverter extends AbstractConverter<AvoirVente, AvoirVenteDto> {

    @Autowired
    private ClientConverter clientConverter ;
    @Autowired
    private AvoirVenteItemConverter avoirVenteItemConverter ;
    @Autowired
    private DepotConverter depotConverter ;
    @Autowired
    private EtatAvoirVenteConverter etatAvoirVenteConverter ;
    @Autowired
    private ProduitConverter produitConverter ;
    @Autowired
    private EntrepriseSocieteConverter entrepriseSocieteConverter ;
    @Autowired
    private VenteConverter venteConverter ;
    @Autowired
    private TaxeConverter taxeConverter ;
    private boolean entrepriseSociete;
    private boolean client;
    private boolean etatAvoirVente;
    private boolean vente;
    private boolean avoirVenteItems;

    public  AvoirVenteConverter(){//Client clientAvoirVenteItem avoirVenteItemDepot depotEtatAvoirVente etatAvoirVenteProduit produitEntrepriseSociete entrepriseSocieteVente venteTaxe taxe,){
        super(AvoirVente.class, AvoirVenteDto.class);
        init(true);
        //this.client =  client ;
        //this.avoirVenteItem =  avoirVenteItem ;
        //this.depot =  depot ;
        //this.etatAvoirVente =  etatAvoirVente ;
        //this.produit =  produit ;
        //this.entrepriseSociete =  entrepriseSociete ;
        //this.vente =  vente ;
        //this.taxe =  taxe ;
    }

    @Override
    public AvoirVente toItem(AvoirVenteDto dto) {
        if (dto == null) {
            return null;
        } else {
        AvoirVente item = new AvoirVente();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getBarCode()))
                item.setBarCode(dto.getBarCode());
            if(StringUtil.isNotEmpty(dto.getCodeAvoirVente()))
                item.setCodeAvoirVente(dto.getCodeAvoirVente());
            if(StringUtil.isNotEmpty(dto.getNumeroFactureAvoirVente()))
                item.setNumeroFactureAvoirVente(dto.getNumeroFactureAvoirVente());
            if(StringUtil.isNotEmpty(dto.getDateFactureAvoirVente()))
                item.setDateFactureAvoirVente(DateUtil.stringEnToDate(dto.getDateFactureAvoirVente()));
            if(StringUtil.isNotEmpty(dto.getMontantHt()))
                item.setMontantHt(dto.getMontantHt());
            if(StringUtil.isNotEmpty(dto.getMontantTva()))
                item.setMontantTva(dto.getMontantTva());
            if(StringUtil.isNotEmpty(dto.getMontantTtc()))
                item.setMontantTtc(dto.getMontantTtc());
            if(StringUtil.isNotEmpty(dto.getDescription()))
                item.setDescription(dto.getDescription());
            if(this.entrepriseSociete && dto.getEntrepriseSociete()!=null &&  dto.getEntrepriseSociete().getId() != null)
                item.setEntrepriseSociete(entrepriseSocieteConverter.toItem(dto.getEntrepriseSociete())) ;

            if(this.client && dto.getClient()!=null &&  dto.getClient().getId() != null)
                item.setClient(clientConverter.toItem(dto.getClient())) ;

            if(this.etatAvoirVente && dto.getEtatAvoirVente()!=null &&  dto.getEtatAvoirVente().getId() != null)
                item.setEtatAvoirVente(etatAvoirVenteConverter.toItem(dto.getEtatAvoirVente())) ;

            if(dto.getVente() != null && dto.getVente().getId() != null){
                item.setVente(new Vente());
                item.getVente().setId(dto.getVente().getId());
                item.getVente().setNumeroFacture(dto.getVente().getNumeroFacture());
            }


            if(this.avoirVenteItems && ListUtil.isNotEmpty(dto.getAvoirVenteItems()))
                item.setAvoirVenteItems(avoirVenteItemConverter.toItem(dto.getAvoirVenteItems()));


        return item;
        }
    }

    @Override
    public AvoirVenteDto toDto(AvoirVente item) {
        if (item == null) {
            return null;
        } else {
            AvoirVenteDto dto = new AvoirVenteDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getBarCode()))
                dto.setBarCode(item.getBarCode());
            if(StringUtil.isNotEmpty(item.getCodeAvoirVente()))
                dto.setCodeAvoirVente(item.getCodeAvoirVente());
            if(StringUtil.isNotEmpty(item.getNumeroFactureAvoirVente()))
                dto.setNumeroFactureAvoirVente(item.getNumeroFactureAvoirVente());
            if(item.getDateFactureAvoirVente()!=null)
                dto.setDateFactureAvoirVente(DateUtil.dateTimeToString(item.getDateFactureAvoirVente()));
            if(StringUtil.isNotEmpty(item.getMontantHt()))
                dto.setMontantHt(item.getMontantHt());
            if(StringUtil.isNotEmpty(item.getMontantTva()))
                dto.setMontantTva(item.getMontantTva());
            if(StringUtil.isNotEmpty(item.getMontantTtc()))
                dto.setMontantTtc(item.getMontantTtc());
            if(StringUtil.isNotEmpty(item.getDescription()))
                dto.setDescription(item.getDescription());
        if(this.entrepriseSociete && item.getEntrepriseSociete()!=null) {
            dto.setEntrepriseSociete(entrepriseSocieteConverter.toDto(item.getEntrepriseSociete())) ;
        }
        if(this.client && item.getClient()!=null) {
            dto.setClient(clientConverter.toDto(item.getClient())) ;
        }
        if(this.etatAvoirVente && item.getEtatAvoirVente()!=null) {
            dto.setEtatAvoirVente(etatAvoirVenteConverter.toDto(item.getEtatAvoirVente())) ;
        }
        if(this.vente && item.getVente()!=null) {
            dto.setVente(venteConverter.toDto(item.getVente())) ;
        }
        if(this.avoirVenteItems && ListUtil.isNotEmpty(item.getAvoirVenteItems())){
            avoirVenteItemConverter.init(true);
            avoirVenteItemConverter.setAvoirVente(false);
            dto.setAvoirVenteItems(avoirVenteItemConverter.toDto(item.getAvoirVenteItems()));
            avoirVenteItemConverter.setAvoirVente(true);

        }


        return dto;
        }
    }

    public void initList(boolean value) {
        this.avoirVenteItems = value;
    }

    public void initObject(boolean value) {
        this.entrepriseSociete = value;
        this.client = value;
        this.etatAvoirVente = value;
        this.vente = value;
    }


    public ClientConverter getClientConverter(){
        return this.clientConverter;
    }
    public void setClientConverter(ClientConverter clientConverter ){
        this.clientConverter = clientConverter;
    }
    public AvoirVenteItemConverter getAvoirVenteItemConverter(){
        return this.avoirVenteItemConverter;
    }
    public void setAvoirVenteItemConverter(AvoirVenteItemConverter avoirVenteItemConverter ){
        this.avoirVenteItemConverter = avoirVenteItemConverter;
    }
    public DepotConverter getDepotConverter(){
        return this.depotConverter;
    }
    public void setDepotConverter(DepotConverter depotConverter ){
        this.depotConverter = depotConverter;
    }
    public EtatAvoirVenteConverter getEtatAvoirVenteConverter(){
        return this.etatAvoirVenteConverter;
    }
    public void setEtatAvoirVenteConverter(EtatAvoirVenteConverter etatAvoirVenteConverter ){
        this.etatAvoirVenteConverter = etatAvoirVenteConverter;
    }
    public ProduitConverter getProduitConverter(){
        return this.produitConverter;
    }
    public void setProduitConverter(ProduitConverter produitConverter ){
        this.produitConverter = produitConverter;
    }
    public EntrepriseSocieteConverter getEntrepriseSocieteConverter(){
        return this.entrepriseSocieteConverter;
    }
    public void setEntrepriseSocieteConverter(EntrepriseSocieteConverter entrepriseSocieteConverter ){
        this.entrepriseSocieteConverter = entrepriseSocieteConverter;
    }
    public VenteConverter getVenteConverter(){
        return this.venteConverter;
    }
    public void setVenteConverter(VenteConverter venteConverter ){
        this.venteConverter = venteConverter;
    }
    public TaxeConverter getTaxeConverter(){
        return this.taxeConverter;
    }
    public void setTaxeConverter(TaxeConverter taxeConverter ){
        this.taxeConverter = taxeConverter;
    }
    public boolean  isEntrepriseSociete(){
        return this.entrepriseSociete;
    }
    public void  setEntrepriseSociete(boolean entrepriseSociete){
        this.entrepriseSociete = entrepriseSociete;
    }
    public boolean  isClient(){
        return this.client;
    }
    public void  setClient(boolean client){
        this.client = client;
    }
    public boolean  isEtatAvoirVente(){
        return this.etatAvoirVente;
    }
    public void  setEtatAvoirVente(boolean etatAvoirVente){
        this.etatAvoirVente = etatAvoirVente;
    }
    public boolean  isVente(){
        return this.vente;
    }
    public void  setVente(boolean vente){
        this.vente = vente;
    }
    public boolean  isAvoirVenteItems(){
        return this.avoirVenteItems ;
    }
    public void  setAvoirVenteItems(boolean avoirVenteItems ){
        this.avoirVenteItems  = avoirVenteItems ;
    }
}
