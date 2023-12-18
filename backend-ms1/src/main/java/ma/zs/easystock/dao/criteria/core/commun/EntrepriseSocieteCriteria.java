package  ma.zs.easystock.dao.criteria.core.commun;



import ma.zs.easystock.zynerator.criteria.BaseCriteria;
import java.util.List;

public class EntrepriseSocieteCriteria extends  BaseCriteria  {

    private String nom;
    private String nomLike;
    private String ice;
    private String iceLike;
    private String capital;
    private String capitalMin;
    private String capitalMax;



    public EntrepriseSocieteCriteria(){}

    public String getNom(){
        return this.nom;
    }
    public void setNom(String nom){
        this.nom = nom;
    }
    public String getNomLike(){
        return this.nomLike;
    }
    public void setNomLike(String nomLike){
        this.nomLike = nomLike;
    }

    public String getIce(){
        return this.ice;
    }
    public void setIce(String ice){
        this.ice = ice;
    }
    public String getIceLike(){
        return this.iceLike;
    }
    public void setIceLike(String iceLike){
        this.iceLike = iceLike;
    }

    public String getCapital(){
        return this.capital;
    }
    public void setCapital(String capital){
        this.capital = capital;
    }   
    public String getCapitalMin(){
        return this.capitalMin;
    }
    public void setCapitalMin(String capitalMin){
        this.capitalMin = capitalMin;
    }
    public String getCapitalMax(){
        return this.capitalMax;
    }
    public void setCapitalMax(String capitalMax){
        this.capitalMax = capitalMax;
    }
      

}
