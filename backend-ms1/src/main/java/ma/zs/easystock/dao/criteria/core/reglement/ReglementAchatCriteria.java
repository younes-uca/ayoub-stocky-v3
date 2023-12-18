package  ma.zs.easystock.dao.criteria.core.reglement;


import ma.zs.easystock.dao.criteria.core.stock.AchatCriteria;
import ma.zs.easystock.dao.criteria.core.gestionchequeffet.ModeReglementCriteria;

import ma.zs.easystock.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class ReglementAchatCriteria extends  BaseCriteria  {

    private String reference;
    private String referenceLike;
    private LocalDateTime dateReglement;
    private LocalDateTime dateReglementFrom;
    private LocalDateTime dateReglementTo;
    private String montant;
    private String montantMin;
    private String montantMax;
    private String description;
    private String descriptionLike;

    private AchatCriteria achat ;
    private List<AchatCriteria> achats ;
    private ModeReglementCriteria modeReglement ;
    private List<ModeReglementCriteria> modeReglements ;


    public ReglementAchatCriteria(){}

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

    public LocalDateTime getDateReglement(){
        return this.dateReglement;
    }
    public void setDateReglement(LocalDateTime dateReglement){
        this.dateReglement = dateReglement;
    }
    public LocalDateTime getDateReglementFrom(){
        return this.dateReglementFrom;
    }
    public void setDateReglementFrom(LocalDateTime dateReglementFrom){
        this.dateReglementFrom = dateReglementFrom;
    }
    public LocalDateTime getDateReglementTo(){
        return this.dateReglementTo;
    }
    public void setDateReglementTo(LocalDateTime dateReglementTo){
        this.dateReglementTo = dateReglementTo;
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


    public AchatCriteria getAchat(){
        return this.achat;
    }

    public void setAchat(AchatCriteria achat){
        this.achat = achat;
    }
    public List<AchatCriteria> getAchats(){
        return this.achats;
    }

    public void setAchats(List<AchatCriteria> achats){
        this.achats = achats;
    }
    public ModeReglementCriteria getModeReglement(){
        return this.modeReglement;
    }

    public void setModeReglement(ModeReglementCriteria modeReglement){
        this.modeReglement = modeReglement;
    }
    public List<ModeReglementCriteria> getModeReglements(){
        return this.modeReglements;
    }

    public void setModeReglements(List<ModeReglementCriteria> modeReglements){
        this.modeReglements = modeReglements;
    }
}
