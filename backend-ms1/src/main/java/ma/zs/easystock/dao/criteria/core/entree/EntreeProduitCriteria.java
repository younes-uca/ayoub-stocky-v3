package  ma.zs.easystock.dao.criteria.core.entree;


import ma.zs.easystock.dao.criteria.core.commun.DepotCriteria;
import ma.zs.easystock.dao.criteria.core.commun.FournisseurCriteria;

import ma.zs.easystock.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class EntreeProduitCriteria extends  BaseCriteria  {

    private String reference;
    private String referenceLike;
    private LocalDateTime dateEntreeProduit;
    private LocalDateTime dateEntreeProduitFrom;
    private LocalDateTime dateEntreeProduitTo;
    private String description;
    private String descriptionLike;

    private FournisseurCriteria fournisseur ;
    private List<FournisseurCriteria> fournisseurs ;
    private DepotCriteria depot ;
    private List<DepotCriteria> depots ;


    public EntreeProduitCriteria(){}

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

    public LocalDateTime getDateEntreeProduit(){
        return this.dateEntreeProduit;
    }
    public void setDateEntreeProduit(LocalDateTime dateEntreeProduit){
        this.dateEntreeProduit = dateEntreeProduit;
    }
    public LocalDateTime getDateEntreeProduitFrom(){
        return this.dateEntreeProduitFrom;
    }
    public void setDateEntreeProduitFrom(LocalDateTime dateEntreeProduitFrom){
        this.dateEntreeProduitFrom = dateEntreeProduitFrom;
    }
    public LocalDateTime getDateEntreeProduitTo(){
        return this.dateEntreeProduitTo;
    }
    public void setDateEntreeProduitTo(LocalDateTime dateEntreeProduitTo){
        this.dateEntreeProduitTo = dateEntreeProduitTo;
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


    public FournisseurCriteria getFournisseur(){
        return this.fournisseur;
    }

    public void setFournisseur(FournisseurCriteria fournisseur){
        this.fournisseur = fournisseur;
    }
    public List<FournisseurCriteria> getFournisseurs(){
        return this.fournisseurs;
    }

    public void setFournisseurs(List<FournisseurCriteria> fournisseurs){
        this.fournisseurs = fournisseurs;
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
