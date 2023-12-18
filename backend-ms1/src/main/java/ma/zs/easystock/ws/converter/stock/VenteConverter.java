package  ma.zs.easystock.ws.converter.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.easystock.zynerator.util.ListUtil;

import ma.zs.easystock.ws.converter.commun.ClientConverter;
import ma.zs.easystock.ws.converter.stock.AvoirVenteItemConverter;
import ma.zs.easystock.ws.converter.reglement.ReglementVenteConverter;
import ma.zs.easystock.ws.converter.stock.ProduitConverter;
import ma.zs.easystock.ws.converter.gestionchequeffet.ModeReglementConverter;
import ma.zs.easystock.ws.converter.stock.VenteItemConverter;
import ma.zs.easystock.ws.converter.stock.AvoirVenteConverter;
import ma.zs.easystock.ws.converter.commun.EtatVenteConverter;
import ma.zs.easystock.ws.converter.commun.DepotConverter;
import ma.zs.easystock.ws.converter.commun.EtatAvoirVenteConverter;
import ma.zs.easystock.ws.converter.commun.EntrepriseSocieteConverter;
import ma.zs.easystock.ws.converter.stock.TaxeConverter;



import ma.zs.easystock.zynerator.util.StringUtil;
import ma.zs.easystock.zynerator.converter.AbstractConverter;
import ma.zs.easystock.zynerator.util.DateUtil;
import ma.zs.easystock.bean.core.stock.Vente;
import ma.zs.easystock.ws.dto.stock.VenteDto;

@Component
public class VenteConverter extends AbstractConverter<Vente, VenteDto> {

    @Autowired
    private ClientConverter clientConverter ;
    @Autowired
    private AvoirVenteItemConverter avoirVenteItemConverter ;
    @Autowired
    private ReglementVenteConverter reglementVenteConverter ;
    @Autowired
    private ProduitConverter produitConverter ;
    @Autowired
    private ModeReglementConverter modeReglementConverter ;
    @Autowired
    private VenteItemConverter venteItemConverter ;
    @Autowired
    private AvoirVenteConverter avoirVenteConverter ;
    @Autowired
    private EtatVenteConverter etatVenteConverter ;
    @Autowired
    private DepotConverter depotConverter ;
    @Autowired
    private EtatAvoirVenteConverter etatAvoirVenteConverter ;
    @Autowired
    private EntrepriseSocieteConverter entrepriseSocieteConverter ;
    @Autowired
    private TaxeConverter taxeConverter ;
    private boolean entrepriseSociete;
    private boolean client;
    private boolean etatVente;
    private boolean venteItems;
    private boolean avoirVentes;
    private boolean reglementVentes;

    public  VenteConverter(){//Client clientAvoirVenteItem avoirVenteItemReglementVente reglementVenteProduit produitModeReglement modeReglementVenteItem venteItemAvoirVente avoirVenteEtatVente etatVenteDepot depotEtatAvoirVente etatAvoirVenteEntrepriseSociete entrepriseSocieteTaxe taxe,){
        super(Vente.class, VenteDto.class);
        init(true);
        //this.client =  client ;
        //this.avoirVenteItem =  avoirVenteItem ;
        //this.reglementVente =  reglementVente ;
        //this.produit =  produit ;
        //this.modeReglement =  modeReglement ;
        //this.venteItem =  venteItem ;
        //this.avoirVente =  avoirVente ;
        //this.etatVente =  etatVente ;
        //this.depot =  depot ;
        //this.etatAvoirVente =  etatAvoirVente ;
        //this.entrepriseSociete =  entrepriseSociete ;
        //this.taxe =  taxe ;
    }

    @Override
    public Vente toItem(VenteDto dto) {
        if (dto == null) {
            return null;
        } else {
        Vente item = new Vente();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getBarCode()))
                item.setBarCode(dto.getBarCode());
            if(StringUtil.isNotEmpty(dto.getCodeVente()))
                item.setCodeVente(dto.getCodeVente());
            if(StringUtil.isNotEmpty(dto.getDateFacture()))
                item.setDateFacture(DateUtil.stringEnToDate(dto.getDateFacture()));
            if(StringUtil.isNotEmpty(dto.getNumeroFacture()))
                item.setNumeroFacture(dto.getNumeroFacture());
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

            if(this.etatVente && dto.getEtatVente()!=null &&  dto.getEtatVente().getId() != null)
                item.setEtatVente(etatVenteConverter.toItem(dto.getEtatVente())) ;


            if(this.venteItems && ListUtil.isNotEmpty(dto.getVenteItems()))
                item.setVenteItems(venteItemConverter.toItem(dto.getVenteItems()));
            if(this.avoirVentes && ListUtil.isNotEmpty(dto.getAvoirVentes()))
                item.setAvoirVentes(avoirVenteConverter.toItem(dto.getAvoirVentes()));
            if(this.reglementVentes && ListUtil.isNotEmpty(dto.getReglementVentes()))
                item.setReglementVentes(reglementVenteConverter.toItem(dto.getReglementVentes()));


        return item;
        }
    }

    @Override
    public VenteDto toDto(Vente item) {
        if (item == null) {
            return null;
        } else {
            VenteDto dto = new VenteDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getBarCode()))
                dto.setBarCode(item.getBarCode());
            if(StringUtil.isNotEmpty(item.getCodeVente()))
                dto.setCodeVente(item.getCodeVente());
            if(item.getDateFacture()!=null)
                dto.setDateFacture(DateUtil.dateTimeToString(item.getDateFacture()));
            if(StringUtil.isNotEmpty(item.getNumeroFacture()))
                dto.setNumeroFacture(item.getNumeroFacture());
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
        if(this.etatVente && item.getEtatVente()!=null) {
            dto.setEtatVente(etatVenteConverter.toDto(item.getEtatVente())) ;
        }
        if(this.venteItems && ListUtil.isNotEmpty(item.getVenteItems())){
            venteItemConverter.init(true);
            venteItemConverter.setVente(false);
            dto.setVenteItems(venteItemConverter.toDto(item.getVenteItems()));
            venteItemConverter.setVente(true);

        }
        if(this.avoirVentes && ListUtil.isNotEmpty(item.getAvoirVentes())){
            avoirVenteConverter.init(true);
            avoirVenteConverter.setVente(false);
            dto.setAvoirVentes(avoirVenteConverter.toDto(item.getAvoirVentes()));
            avoirVenteConverter.setVente(true);

        }
        if(this.reglementVentes && ListUtil.isNotEmpty(item.getReglementVentes())){
            reglementVenteConverter.init(true);
            reglementVenteConverter.setVente(false);
            dto.setReglementVentes(reglementVenteConverter.toDto(item.getReglementVentes()));
            reglementVenteConverter.setVente(true);

        }


        return dto;
        }
    }

    public void initList(boolean value) {
        this.venteItems = value;
        this.avoirVentes = value;
        this.reglementVentes = value;
    }

    public void initObject(boolean value) {
        this.entrepriseSociete = value;
        this.client = value;
        this.etatVente = value;
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
    public ReglementVenteConverter getReglementVenteConverter(){
        return this.reglementVenteConverter;
    }
    public void setReglementVenteConverter(ReglementVenteConverter reglementVenteConverter ){
        this.reglementVenteConverter = reglementVenteConverter;
    }
    public ProduitConverter getProduitConverter(){
        return this.produitConverter;
    }
    public void setProduitConverter(ProduitConverter produitConverter ){
        this.produitConverter = produitConverter;
    }
    public ModeReglementConverter getModeReglementConverter(){
        return this.modeReglementConverter;
    }
    public void setModeReglementConverter(ModeReglementConverter modeReglementConverter ){
        this.modeReglementConverter = modeReglementConverter;
    }
    public VenteItemConverter getVenteItemConverter(){
        return this.venteItemConverter;
    }
    public void setVenteItemConverter(VenteItemConverter venteItemConverter ){
        this.venteItemConverter = venteItemConverter;
    }
    public AvoirVenteConverter getAvoirVenteConverter(){
        return this.avoirVenteConverter;
    }
    public void setAvoirVenteConverter(AvoirVenteConverter avoirVenteConverter ){
        this.avoirVenteConverter = avoirVenteConverter;
    }
    public EtatVenteConverter getEtatVenteConverter(){
        return this.etatVenteConverter;
    }
    public void setEtatVenteConverter(EtatVenteConverter etatVenteConverter ){
        this.etatVenteConverter = etatVenteConverter;
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
    public EntrepriseSocieteConverter getEntrepriseSocieteConverter(){
        return this.entrepriseSocieteConverter;
    }
    public void setEntrepriseSocieteConverter(EntrepriseSocieteConverter entrepriseSocieteConverter ){
        this.entrepriseSocieteConverter = entrepriseSocieteConverter;
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
    public boolean  isEtatVente(){
        return this.etatVente;
    }
    public void  setEtatVente(boolean etatVente){
        this.etatVente = etatVente;
    }
    public boolean  isVenteItems(){
        return this.venteItems ;
    }
    public void  setVenteItems(boolean venteItems ){
        this.venteItems  = venteItems ;
    }
    public boolean  isAvoirVentes(){
        return this.avoirVentes ;
    }
    public void  setAvoirVentes(boolean avoirVentes ){
        this.avoirVentes  = avoirVentes ;
    }
    public boolean  isReglementVentes(){
        return this.reglementVentes ;
    }
    public void  setReglementVentes(boolean reglementVentes ){
        this.reglementVentes  = reglementVentes ;
    }
}
