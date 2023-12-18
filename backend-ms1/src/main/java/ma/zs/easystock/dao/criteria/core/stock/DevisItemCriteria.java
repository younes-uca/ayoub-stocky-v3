package  ma.zs.easystock.dao.criteria.core.stock;



import ma.zs.easystock.zynerator.criteria.BaseCriteria;
import java.util.List;

public class DevisItemCriteria extends  BaseCriteria  {

    private String quantite;
    private String quantiteMin;
    private String quantiteMax;
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
    private DevisCriteria devis ;
    private List<DevisCriteria> deviss ;


    public DevisItemCriteria(){}

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
    public DevisCriteria getDevis(){
        return this.devis;
    }

    public void setDevis(DevisCriteria devis){
        this.devis = devis;
    }
    public List<DevisCriteria> getDeviss(){
        return this.deviss;
    }

    public void setDeviss(List<DevisCriteria> deviss){
        this.deviss = deviss;
    }
}
