package  ma.zs.easystock.dao.criteria.core.gestionchequeffet;



import ma.zs.easystock.zynerator.criteria.BaseCriteria;
import java.util.List;

public class ModeReglementCriteria extends  BaseCriteria  {

    private String libelle;
    private String libelleLike;



    public ModeReglementCriteria(){}

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


}
