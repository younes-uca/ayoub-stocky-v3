package  ma.zs.easystock.ws.converter.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.easystock.zynerator.util.ListUtil;

import ma.zs.easystock.ws.converter.commun.FournisseurConverter;
import ma.zs.easystock.ws.converter.commun.EtatAchatConverter;
import ma.zs.easystock.ws.converter.stock.ProduitConverter;
import ma.zs.easystock.ws.converter.stock.AvoirAchatConverter;
import ma.zs.easystock.ws.converter.commun.EtatAvoirAchatConverter;
import ma.zs.easystock.ws.converter.stock.AchatItemConverter;
import ma.zs.easystock.ws.converter.stock.AvoirAchatItemConverter;
import ma.zs.easystock.ws.converter.commun.DepotConverter;
import ma.zs.easystock.ws.converter.commun.EntrepriseSocieteConverter;
import ma.zs.easystock.ws.converter.stock.TaxeConverter;



import ma.zs.easystock.zynerator.util.StringUtil;
import ma.zs.easystock.zynerator.converter.AbstractConverter;
import ma.zs.easystock.zynerator.util.DateUtil;
import ma.zs.easystock.bean.core.stock.Achat;
import ma.zs.easystock.ws.dto.stock.AchatDto;

@Component
public class AchatConverter extends AbstractConverter<Achat, AchatDto> {

    @Autowired
    private FournisseurConverter fournisseurConverter ;
    @Autowired
    private EtatAchatConverter etatAchatConverter ;
    @Autowired
    private ProduitConverter produitConverter ;
    @Autowired
    private AvoirAchatConverter avoirAchatConverter ;
    @Autowired
    private EtatAvoirAchatConverter etatAvoirAchatConverter ;
    @Autowired
    private AchatItemConverter achatItemConverter ;
    @Autowired
    private AvoirAchatItemConverter avoirAchatItemConverter ;
    @Autowired
    private DepotConverter depotConverter ;
    @Autowired
    private EntrepriseSocieteConverter entrepriseSocieteConverter ;
    @Autowired
    private TaxeConverter taxeConverter ;
    private boolean entrepriseSociete;
    private boolean fournisseur;
    private boolean etatAchat;
    private boolean achatItems;
    private boolean avoirAchats;

    public  AchatConverter(){//Fournisseur fournisseurEtatAchat etatAchatProduit produitAvoirAchat avoirAchatEtatAvoirAchat etatAvoirAchatAchatItem achatItemAvoirAchatItem avoirAchatItemDepot depotEntrepriseSociete entrepriseSocieteTaxe taxe,){
        super(Achat.class, AchatDto.class);
        init(true);
        //this.fournisseur =  fournisseur ;
        //this.etatAchat =  etatAchat ;
        //this.produit =  produit ;
        //this.avoirAchat =  avoirAchat ;
        //this.etatAvoirAchat =  etatAvoirAchat ;
        //this.achatItem =  achatItem ;
        //this.avoirAchatItem =  avoirAchatItem ;
        //this.depot =  depot ;
        //this.entrepriseSociete =  entrepriseSociete ;
        //this.taxe =  taxe ;
    }

    @Override
    public Achat toItem(AchatDto dto) {
        if (dto == null) {
            return null;
        } else {
        Achat item = new Achat();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getDateFacture()))
                item.setDateFacture(DateUtil.stringEnToDate(dto.getDateFacture()));
            if(StringUtil.isNotEmpty(dto.getReferenceFacture()))
                item.setReferenceFacture(dto.getReferenceFacture());
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

            if(this.fournisseur && dto.getFournisseur()!=null &&  dto.getFournisseur().getId() != null)
                item.setFournisseur(fournisseurConverter.toItem(dto.getFournisseur())) ;

            if(this.etatAchat && dto.getEtatAchat()!=null &&  dto.getEtatAchat().getId() != null)
                item.setEtatAchat(etatAchatConverter.toItem(dto.getEtatAchat())) ;


            if(this.achatItems && ListUtil.isNotEmpty(dto.getAchatItems()))
                item.setAchatItems(achatItemConverter.toItem(dto.getAchatItems()));
            if(this.avoirAchats && ListUtil.isNotEmpty(dto.getAvoirAchats()))
                item.setAvoirAchats(avoirAchatConverter.toItem(dto.getAvoirAchats()));


        return item;
        }
    }

    @Override
    public AchatDto toDto(Achat item) {
        if (item == null) {
            return null;
        } else {
            AchatDto dto = new AchatDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(item.getDateFacture()!=null)
                dto.setDateFacture(DateUtil.dateTimeToString(item.getDateFacture()));
            if(StringUtil.isNotEmpty(item.getReferenceFacture()))
                dto.setReferenceFacture(item.getReferenceFacture());
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
        if(this.fournisseur && item.getFournisseur()!=null) {
            dto.setFournisseur(fournisseurConverter.toDto(item.getFournisseur())) ;
        }
        if(this.etatAchat && item.getEtatAchat()!=null) {
            dto.setEtatAchat(etatAchatConverter.toDto(item.getEtatAchat())) ;
        }
        if(this.achatItems && ListUtil.isNotEmpty(item.getAchatItems())){
            achatItemConverter.init(true);
            achatItemConverter.setAchat(false);
            dto.setAchatItems(achatItemConverter.toDto(item.getAchatItems()));
            achatItemConverter.setAchat(true);

        }
        if(this.avoirAchats && ListUtil.isNotEmpty(item.getAvoirAchats())){
            avoirAchatConverter.init(true);
            avoirAchatConverter.setAchat(false);
            dto.setAvoirAchats(avoirAchatConverter.toDto(item.getAvoirAchats()));
            avoirAchatConverter.setAchat(true);

        }


        return dto;
        }
    }

    public void initList(boolean value) {
        this.achatItems = value;
        this.avoirAchats = value;
    }

    public void initObject(boolean value) {
        this.entrepriseSociete = value;
        this.fournisseur = value;
        this.etatAchat = value;
    }


    public FournisseurConverter getFournisseurConverter(){
        return this.fournisseurConverter;
    }
    public void setFournisseurConverter(FournisseurConverter fournisseurConverter ){
        this.fournisseurConverter = fournisseurConverter;
    }
    public EtatAchatConverter getEtatAchatConverter(){
        return this.etatAchatConverter;
    }
    public void setEtatAchatConverter(EtatAchatConverter etatAchatConverter ){
        this.etatAchatConverter = etatAchatConverter;
    }
    public ProduitConverter getProduitConverter(){
        return this.produitConverter;
    }
    public void setProduitConverter(ProduitConverter produitConverter ){
        this.produitConverter = produitConverter;
    }
    public AvoirAchatConverter getAvoirAchatConverter(){
        return this.avoirAchatConverter;
    }
    public void setAvoirAchatConverter(AvoirAchatConverter avoirAchatConverter ){
        this.avoirAchatConverter = avoirAchatConverter;
    }
    public EtatAvoirAchatConverter getEtatAvoirAchatConverter(){
        return this.etatAvoirAchatConverter;
    }
    public void setEtatAvoirAchatConverter(EtatAvoirAchatConverter etatAvoirAchatConverter ){
        this.etatAvoirAchatConverter = etatAvoirAchatConverter;
    }
    public AchatItemConverter getAchatItemConverter(){
        return this.achatItemConverter;
    }
    public void setAchatItemConverter(AchatItemConverter achatItemConverter ){
        this.achatItemConverter = achatItemConverter;
    }
    public AvoirAchatItemConverter getAvoirAchatItemConverter(){
        return this.avoirAchatItemConverter;
    }
    public void setAvoirAchatItemConverter(AvoirAchatItemConverter avoirAchatItemConverter ){
        this.avoirAchatItemConverter = avoirAchatItemConverter;
    }
    public DepotConverter getDepotConverter(){
        return this.depotConverter;
    }
    public void setDepotConverter(DepotConverter depotConverter ){
        this.depotConverter = depotConverter;
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
    public boolean  isFournisseur(){
        return this.fournisseur;
    }
    public void  setFournisseur(boolean fournisseur){
        this.fournisseur = fournisseur;
    }
    public boolean  isEtatAchat(){
        return this.etatAchat;
    }
    public void  setEtatAchat(boolean etatAchat){
        this.etatAchat = etatAchat;
    }
    public boolean  isAchatItems(){
        return this.achatItems ;
    }
    public void  setAchatItems(boolean achatItems ){
        this.achatItems  = achatItems ;
    }
    public boolean  isAvoirAchats(){
        return this.avoirAchats ;
    }
    public void  setAvoirAchats(boolean avoirAchats ){
        this.avoirAchats  = avoirAchats ;
    }
}
