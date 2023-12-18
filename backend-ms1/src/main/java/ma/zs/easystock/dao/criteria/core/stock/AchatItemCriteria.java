package  ma.zs.easystock.dao.criteria.core.stock;


import ma.zs.easystock.dao.criteria.core.commun.DepotCriteria;

import ma.zs.easystock.zynerator.criteria.BaseCriteria;
import java.util.List;

public class AchatItemCriteria extends  BaseCriteria  {

    private String barCode;
    private String barCodeLike;
    private String footerBarCode;
    private String footerBarCodeLike;
    private String quantite;
    private String quantiteMin;
    private String quantiteMax;
    private String quantiteAvoir;
    private String quantiteAvoirMin;
    private String quantiteAvoirMax;
    private String quantiteDisponible;
    private String quantiteDisponibleMin;
    private String quantiteDisponibleMax;
    private String prixUnitaireHt;
    private String prixUnitaireHtMin;
    private String prixUnitaireHtMax;
    private String prixUnitaireTtc;
    private String prixUnitaireTtcMin;
    private String prixUnitaireTtcMax;
    private String remise;
    private String remiseMin;
    private String remiseMax;
    private String montantHt;
    private String montantHtMin;
    private String montantHtMax;
    private String montantTtc;
    private String montantTtcMin;
    private String montantTtcMax;

    private ProduitCriteria produit ;
    private List<ProduitCriteria> produits ;
    private TaxeCriteria taxe ;
    private List<TaxeCriteria> taxes ;
    private AchatCriteria achat ;
    private List<AchatCriteria> achats ;
    private DepotCriteria depot ;
    private List<DepotCriteria> depots ;


    public AchatItemCriteria(){}

    public String getBarCode(){
        return this.barCode;
    }
    public void setBarCode(String barCode){
        this.barCode = barCode;
    }
    public String getBarCodeLike(){
        return this.barCodeLike;
    }
    public void setBarCodeLike(String barCodeLike){
        this.barCodeLike = barCodeLike;
    }

    public String getFooterBarCode(){
        return this.footerBarCode;
    }
    public void setFooterBarCode(String footerBarCode){
        this.footerBarCode = footerBarCode;
    }
    public String getFooterBarCodeLike(){
        return this.footerBarCodeLike;
    }
    public void setFooterBarCodeLike(String footerBarCodeLike){
        this.footerBarCodeLike = footerBarCodeLike;
    }

    public String getQuantite(){
        return this.quantite;
    }
    public void setQuantite(String quantite){
        this.quantite = quantite;
    }   
    public String getQuantiteMin(){
        return this.quantiteMin;
    }
    public void setQuantiteMin(String quantiteMin){
        this.quantiteMin = quantiteMin;
    }
    public String getQuantiteMax(){
        return this.quantiteMax;
    }
    public void setQuantiteMax(String quantiteMax){
        this.quantiteMax = quantiteMax;
    }
      
    public String getQuantiteAvoir(){
        return this.quantiteAvoir;
    }
    public void setQuantiteAvoir(String quantiteAvoir){
        this.quantiteAvoir = quantiteAvoir;
    }   
    public String getQuantiteAvoirMin(){
        return this.quantiteAvoirMin;
    }
    public void setQuantiteAvoirMin(String quantiteAvoirMin){
        this.quantiteAvoirMin = quantiteAvoirMin;
    }
    public String getQuantiteAvoirMax(){
        return this.quantiteAvoirMax;
    }
    public void setQuantiteAvoirMax(String quantiteAvoirMax){
        this.quantiteAvoirMax = quantiteAvoirMax;
    }
      
    public String getQuantiteDisponible(){
        return this.quantiteDisponible;
    }
    public void setQuantiteDisponible(String quantiteDisponible){
        this.quantiteDisponible = quantiteDisponible;
    }   
    public String getQuantiteDisponibleMin(){
        return this.quantiteDisponibleMin;
    }
    public void setQuantiteDisponibleMin(String quantiteDisponibleMin){
        this.quantiteDisponibleMin = quantiteDisponibleMin;
    }
    public String getQuantiteDisponibleMax(){
        return this.quantiteDisponibleMax;
    }
    public void setQuantiteDisponibleMax(String quantiteDisponibleMax){
        this.quantiteDisponibleMax = quantiteDisponibleMax;
    }
      
    public String getPrixUnitaireHt(){
        return this.prixUnitaireHt;
    }
    public void setPrixUnitaireHt(String prixUnitaireHt){
        this.prixUnitaireHt = prixUnitaireHt;
    }   
    public String getPrixUnitaireHtMin(){
        return this.prixUnitaireHtMin;
    }
    public void setPrixUnitaireHtMin(String prixUnitaireHtMin){
        this.prixUnitaireHtMin = prixUnitaireHtMin;
    }
    public String getPrixUnitaireHtMax(){
        return this.prixUnitaireHtMax;
    }
    public void setPrixUnitaireHtMax(String prixUnitaireHtMax){
        this.prixUnitaireHtMax = prixUnitaireHtMax;
    }
      
    public String getPrixUnitaireTtc(){
        return this.prixUnitaireTtc;
    }
    public void setPrixUnitaireTtc(String prixUnitaireTtc){
        this.prixUnitaireTtc = prixUnitaireTtc;
    }   
    public String getPrixUnitaireTtcMin(){
        return this.prixUnitaireTtcMin;
    }
    public void setPrixUnitaireTtcMin(String prixUnitaireTtcMin){
        this.prixUnitaireTtcMin = prixUnitaireTtcMin;
    }
    public String getPrixUnitaireTtcMax(){
        return this.prixUnitaireTtcMax;
    }
    public void setPrixUnitaireTtcMax(String prixUnitaireTtcMax){
        this.prixUnitaireTtcMax = prixUnitaireTtcMax;
    }
      
    public String getRemise(){
        return this.remise;
    }
    public void setRemise(String remise){
        this.remise = remise;
    }   
    public String getRemiseMin(){
        return this.remiseMin;
    }
    public void setRemiseMin(String remiseMin){
        this.remiseMin = remiseMin;
    }
    public String getRemiseMax(){
        return this.remiseMax;
    }
    public void setRemiseMax(String remiseMax){
        this.remiseMax = remiseMax;
    }
      
    public String getMontantHt(){
        return this.montantHt;
    }
    public void setMontantHt(String montantHt){
        this.montantHt = montantHt;
    }   
    public String getMontantHtMin(){
        return this.montantHtMin;
    }
    public void setMontantHtMin(String montantHtMin){
        this.montantHtMin = montantHtMin;
    }
    public String getMontantHtMax(){
        return this.montantHtMax;
    }
    public void setMontantHtMax(String montantHtMax){
        this.montantHtMax = montantHtMax;
    }
      
    public String getMontantTtc(){
        return this.montantTtc;
    }
    public void setMontantTtc(String montantTtc){
        this.montantTtc = montantTtc;
    }   
    public String getMontantTtcMin(){
        return this.montantTtcMin;
    }
    public void setMontantTtcMin(String montantTtcMin){
        this.montantTtcMin = montantTtcMin;
    }
    public String getMontantTtcMax(){
        return this.montantTtcMax;
    }
    public void setMontantTtcMax(String montantTtcMax){
        this.montantTtcMax = montantTtcMax;
    }
      

    public ProduitCriteria getProduit(){
        return this.produit;
    }

    public void setProduit(ProduitCriteria produit){
        this.produit = produit;
    }
    public List<ProduitCriteria> getProduits(){
        return this.produits;
    }

    public void setProduits(List<ProduitCriteria> produits){
        this.produits = produits;
    }
    public TaxeCriteria getTaxe(){
        return this.taxe;
    }

    public void setTaxe(TaxeCriteria taxe){
        this.taxe = taxe;
    }
    public List<TaxeCriteria> getTaxes(){
        return this.taxes;
    }

    public void setTaxes(List<TaxeCriteria> taxes){
        this.taxes = taxes;
    }
    public AchatCriteria getAchat(){
        return this.achat;
    }

    public void setAchat(AchatCriteria achat){
        this.achat = achat;
    }
    public List<AchatCriteria> getAchats(){
        return this.achats;
    }

    public void setAchats(List<AchatCriteria> achats){
        this.achats = achats;
    }
    public DepotCriteria getDepot(){
        return this.depot;
    }

    public void setDepot(DepotCriteria depot){
        this.depot = depot;
    }
    public List<DepotCriteria> getDepots(){
        return this.depots;
    }

    public void setDepots(List<DepotCriteria> depots){
        this.depots = depots;
    }
}
