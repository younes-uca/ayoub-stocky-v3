package  ma.zs.easystock.dao.criteria.core.depense;



import ma.zs.easystock.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class DepenseCriteria extends  BaseCriteria  {

    private LocalDateTime dateDepense;
    private LocalDateTime dateDepenseFrom;
    private LocalDateTime dateDepenseTo;
    private String libelle;
    private String libelleLike;
    private String montant;
    private String montantMin;
    private String montantMax;
    private String description;
    private String descriptionLike;



    public DepenseCriteria(){}

    public LocalDateTime getDateDepense(){
        return this.dateDepense;
    }
    public void setDateDepense(LocalDateTime dateDepense){
        this.dateDepense = dateDepense;
    }
    public LocalDateTime getDateDepenseFrom(){
        return this.dateDepenseFrom;
    }
    public void setDateDepenseFrom(LocalDateTime dateDepenseFrom){
        this.dateDepenseFrom = dateDepenseFrom;
    }
    public LocalDateTime getDateDepenseTo(){
        return this.dateDepenseTo;
    }
    public void setDateDepenseTo(LocalDateTime dateDepenseTo){
        this.dateDepenseTo = dateDepenseTo;
    }
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


}
