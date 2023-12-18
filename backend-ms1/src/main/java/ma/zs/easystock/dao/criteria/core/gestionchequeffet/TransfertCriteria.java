package  ma.zs.easystock.dao.criteria.core.gestionchequeffet;


import ma.zs.easystock.dao.criteria.core.Transfert.RaisonCriteria;

import ma.zs.easystock.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class TransfertCriteria extends  BaseCriteria  {

    private String reference;
    private String referenceLike;
    private LocalDateTime dateTransfert;
    private LocalDateTime dateTransfertFrom;
    private LocalDateTime dateTransfertTo;
    private String description;
    private String descriptionLike;

    private RaisonCriteria raison ;
    private List<RaisonCriteria> raisons ;


    public TransfertCriteria(){}

    public String getReference(){
        return this.reference;
    }
    public void setReference(String reference){
        this.reference = reference;
    }
    public String getReferenceLike(){
        return this.referenceLike;
    }
    public void setReferenceLike(String referenceLike){
        this.referenceLike = referenceLike;
    }

    public LocalDateTime getDateTransfert(){
        return this.dateTransfert;
    }
    public void setDateTransfert(LocalDateTime dateTransfert){
        this.dateTransfert = dateTransfert;
    }
    public LocalDateTime getDateTransfertFrom(){
        return this.dateTransfertFrom;
    }
    public void setDateTransfertFrom(LocalDateTime dateTransfertFrom){
        this.dateTransfertFrom = dateTransfertFrom;
    }
    public LocalDateTime getDateTransfertTo(){
        return this.dateTransfertTo;
    }
    public void setDateTransfertTo(LocalDateTime dateTransfertTo){
        this.dateTransfertTo = dateTransfertTo;
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


    public RaisonCriteria getRaison(){
        return this.raison;
    }

    public void setRaison(RaisonCriteria raison){
        this.raison = raison;
    }
    public List<RaisonCriteria> getRaisons(){
        return this.raisons;
    }

    public void setRaisons(List<RaisonCriteria> raisons){
        this.raisons = raisons;
    }
}
