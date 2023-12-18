package  ma.zs.easystock.dao.criteria.core.stock;


import ma.zs.easystock.dao.criteria.core.entree.SortieProduitCriteria;

import ma.zs.easystock.zynerator.criteria.BaseCriteria;
import java.util.List;

public class SortieProduitItemCriteria extends  BaseCriteria  {

    private String quantite;
    private String quantiteMin;
    private String quantiteMax;
    private String description;
    private String descriptionLike;

    private ProduitCriteria produit ;
    private List<ProduitCriteria> produits ;
    private SortieProduitCriteria sortieProduit ;
    private List<SortieProduitCriteria> sortieProduits ;


    public SortieProduitItemCriteria(){}

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
      
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescriptionLike(){
        return this.descriptionLike;
    }
    public void setDescriptionLike(String descriptionLike){
        this.descriptionLike = descriptionLike;
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
    public SortieProduitCriteria getSortieProduit(){
        return this.sortieProduit;
    }

    public void setSortieProduit(SortieProduitCriteria sortieProduit){
        this.sortieProduit = sortieProduit;
    }
    public List<SortieProduitCriteria> getSortieProduits(){
        return this.sortieProduits;
    }

    public void setSortieProduits(List<SortieProduitCriteria> sortieProduits){
        this.sortieProduits = sortieProduits;
    }
}
