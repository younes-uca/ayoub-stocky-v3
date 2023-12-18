package  ma.zs.easystock.dao.criteria.core.entree;


import ma.zs.easystock.dao.criteria.core.commun.DepotCriteria;

import ma.zs.easystock.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class SortieProduitCriteria extends  BaseCriteria  {

    private String reference;
    private String referenceLike;
    private LocalDateTime dateSortieProduit;
    private LocalDateTime dateSortieProduitFrom;
    private LocalDateTime dateSortieProduitTo;
    private String description;
    private String descriptionLike;

    private DepotCriteria depot ;
    private List<DepotCriteria> depots ;


    public SortieProduitCriteria(){}

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

    public LocalDateTime getDateSortieProduit(){
        return this.dateSortieProduit;
    }
    public void setDateSortieProduit(LocalDateTime dateSortieProduit){
        this.dateSortieProduit = dateSortieProduit;
    }
    public LocalDateTime getDateSortieProduitFrom(){
        return this.dateSortieProduitFrom;
    }
    public void setDateSortieProduitFrom(LocalDateTime dateSortieProduitFrom){
        this.dateSortieProduitFrom = dateSortieProduitFrom;
    }
    public LocalDateTime getDateSortieProduitTo(){
        return this.dateSortieProduitTo;
    }
    public void setDateSortieProduitTo(LocalDateTime dateSortieProduitTo){
        this.dateSortieProduitTo = dateSortieProduitTo;
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
