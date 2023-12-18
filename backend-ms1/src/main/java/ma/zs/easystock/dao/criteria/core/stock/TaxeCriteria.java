package  ma.zs.easystock.dao.criteria.core.stock;



import ma.zs.easystock.zynerator.criteria.BaseCriteria;
import java.util.List;

public class TaxeCriteria extends  BaseCriteria  {

    private String libelle;
    private String libelleLike;
    private String montant;
    private String montantMin;
    private String montantMax;



    public TaxeCriteria(){}

    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }
    public String getLibelleLike(){
        return this.libelleLike;
    }
    public void setLibelleLike(String libelleLike){
        this.libelleLike = libelleLike;
    }

    public String getMontant(){
        return this.montant;
    }
    public void setMontant(String montant){
        this.montant = montant;
    }   
    public String getMontantMin(){
        return this.montantMin;
    }
    public void setMontantMin(String montantMin){
        this.montantMin = montantMin;
    }
    public String getMontantMax(){
        return this.montantMax;
    }
    public void setMontantMax(String montantMax){
        this.montantMax = montantMax;
    }
      

}
