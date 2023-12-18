package  ma.zs.easystock.dao.criteria.core.stock;



import ma.zs.easystock.zynerator.criteria.BaseCriteria;
import java.util.List;

public class InventaireItemCriteria extends  BaseCriteria  {

    private String quantiteEstime;
    private String quantiteEstimeMin;
    private String quantiteEstimeMax;
    private String quantiteReelle;
    private String quantiteReelleMin;
    private String quantiteReelleMax;

    private ProduitCriteria produit ;
    private List<ProduitCriteria> produits ;
    private InventaireCriteria inventaire ;
    private List<InventaireCriteria> inventaires ;


    public InventaireItemCriteria(){}

    public String getQuantiteEstime(){
        return this.quantiteEstime;
    }
    public void setQuantiteEstime(String quantiteEstime){
        this.quantiteEstime = quantiteEstime;
    }   
    public String getQuantiteEstimeMin(){
        return this.quantiteEstimeMin;
    }
    public void setQuantiteEstimeMin(String quantiteEstimeMin){
        this.quantiteEstimeMin = quantiteEstimeMin;
    }
    public String getQuantiteEstimeMax(){
        return this.quantiteEstimeMax;
    }
    public void setQuantiteEstimeMax(String quantiteEstimeMax){
        this.quantiteEstimeMax = quantiteEstimeMax;
    }
      
    public String getQuantiteReelle(){
        return this.quantiteReelle;
    }
    public void setQuantiteReelle(String quantiteReelle){
        this.quantiteReelle = quantiteReelle;
    }   
    public String getQuantiteReelleMin(){
        return this.quantiteReelleMin;
    }
    public void setQuantiteReelleMin(String quantiteReelleMin){
        this.quantiteReelleMin = quantiteReelleMin;
    }
    public String getQuantiteReelleMax(){
        return this.quantiteReelleMax;
    }
    public void setQuantiteReelleMax(String quantiteReelleMax){
        this.quantiteReelleMax = quantiteReelleMax;
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
    public InventaireCriteria getInventaire(){
        return this.inventaire;
    }

    public void setInventaire(InventaireCriteria inventaire){
        this.inventaire = inventaire;
    }
    public List<InventaireCriteria> getInventaires(){
        return this.inventaires;
    }

    public void setInventaires(List<InventaireCriteria> inventaires){
        this.inventaires = inventaires;
    }
}
