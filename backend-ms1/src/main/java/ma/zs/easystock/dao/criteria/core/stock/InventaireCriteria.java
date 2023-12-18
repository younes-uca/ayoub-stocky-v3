package  ma.zs.easystock.dao.criteria.core.stock;


import ma.zs.easystock.dao.criteria.core.commun.DepotCriteria;
import ma.zs.easystock.dao.criteria.core.commun.EntrepriseSocieteCriteria;

import ma.zs.easystock.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class InventaireCriteria extends  BaseCriteria  {

    private String reference;
    private String referenceLike;
    private LocalDateTime dateInventaire;
    private LocalDateTime dateInventaireFrom;
    private LocalDateTime dateInventaireTo;
    private String description;
    private String descriptionLike;

    private EntrepriseSocieteCriteria entrepriseSociete ;
    private List<EntrepriseSocieteCriteria> entrepriseSocietes ;
    private DepotCriteria depot ;
    private List<DepotCriteria> depots ;


    public InventaireCriteria(){}

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

    public LocalDateTime getDateInventaire(){
        return this.dateInventaire;
    }
    public void setDateInventaire(LocalDateTime dateInventaire){
        this.dateInventaire = dateInventaire;
    }
    public LocalDateTime getDateInventaireFrom(){
        return this.dateInventaireFrom;
    }
    public void setDateInventaireFrom(LocalDateTime dateInventaireFrom){
        this.dateInventaireFrom = dateInventaireFrom;
    }
    public LocalDateTime getDateInventaireTo(){
        return this.dateInventaireTo;
    }
    public void setDateInventaireTo(LocalDateTime dateInventaireTo){
        this.dateInventaireTo = dateInventaireTo;
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


    public EntrepriseSocieteCriteria getEntrepriseSociete(){
        return this.entrepriseSociete;
    }

    public void setEntrepriseSociete(EntrepriseSocieteCriteria entrepriseSociete){
        this.entrepriseSociete = entrepriseSociete;
    }
    public List<EntrepriseSocieteCriteria> getEntrepriseSocietes(){
        return this.entrepriseSocietes;
    }

    public void setEntrepriseSocietes(List<EntrepriseSocieteCriteria> entrepriseSocietes){
        this.entrepriseSocietes = entrepriseSocietes;
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
