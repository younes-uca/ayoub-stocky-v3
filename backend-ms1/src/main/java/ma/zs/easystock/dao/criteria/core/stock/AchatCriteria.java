package  ma.zs.easystock.dao.criteria.core.stock;


import ma.zs.easystock.dao.criteria.core.commun.EtatAchatCriteria;
import ma.zs.easystock.dao.criteria.core.commun.EntrepriseSocieteCriteria;
import ma.zs.easystock.dao.criteria.core.commun.FournisseurCriteria;

import ma.zs.easystock.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class AchatCriteria extends  BaseCriteria  {

    private LocalDateTime dateFacture;
    private LocalDateTime dateFactureFrom;
    private LocalDateTime dateFactureTo;
    private String referenceFacture;
    private String referenceFactureLike;
    private String montantHt;
    private String montantHtMin;
    private String montantHtMax;
    private String montantTva;
    private String montantTvaMin;
    private String montantTvaMax;
    private String montantTtc;
    private String montantTtcMin;
    private String montantTtcMax;
    private String description;
    private String descriptionLike;

    private EntrepriseSocieteCriteria entrepriseSociete ;
    private List<EntrepriseSocieteCriteria> entrepriseSocietes ;
    private FournisseurCriteria fournisseur ;
    private List<FournisseurCriteria> fournisseurs ;
    private EtatAchatCriteria etatAchat ;
    private List<EtatAchatCriteria> etatAchats ;


    public AchatCriteria(){}

    public LocalDateTime getDateFacture(){
        return this.dateFacture;
    }
    public void setDateFacture(LocalDateTime dateFacture){
        this.dateFacture = dateFacture;
    }
    public LocalDateTime getDateFactureFrom(){
        return this.dateFactureFrom;
    }
    public void setDateFactureFrom(LocalDateTime dateFactureFrom){
        this.dateFactureFrom = dateFactureFrom;
    }
    public LocalDateTime getDateFactureTo(){
        return this.dateFactureTo;
    }
    public void setDateFactureTo(LocalDateTime dateFactureTo){
        this.dateFactureTo = dateFactureTo;
    }
    public String getReferenceFacture(){
        return this.referenceFacture;
    }
    public void setReferenceFacture(String referenceFacture){
        this.referenceFacture = referenceFacture;
    }
    public String getReferenceFactureLike(){
        return this.referenceFactureLike;
    }
    public void setReferenceFactureLike(String referenceFactureLike){
        this.referenceFactureLike = referenceFactureLike;
    }

    public String getMontantHt(){
        return this.montantHt;
    }
    public void setMontantHt(String montantHt){
        this.montantHt = montantHt;
    }   
    public String getMontantHtMin(){
        return this.montantHtMin;
    }
    public void setMontantHtMin(String montantHtMin){
        this.montantHtMin = montantHtMin;
    }
    public String getMontantHtMax(){
        return this.montantHtMax;
    }
    public void setMontantHtMax(String montantHtMax){
        this.montantHtMax = montantHtMax;
    }
      
    public String getMontantTva(){
        return this.montantTva;
    }
    public void setMontantTva(String montantTva){
        this.montantTva = montantTva;
    }   
    public String getMontantTvaMin(){
        return this.montantTvaMin;
    }
    public void setMontantTvaMin(String montantTvaMin){
        this.montantTvaMin = montantTvaMin;
    }
    public String getMontantTvaMax(){
        return this.montantTvaMax;
    }
    public void setMontantTvaMax(String montantTvaMax){
        this.montantTvaMax = montantTvaMax;
    }
      
    public String getMontantTtc(){
        return this.montantTtc;
    }
    public void setMontantTtc(String montantTtc){
        this.montantTtc = montantTtc;
    }   
    public String getMontantTtcMin(){
        return this.montantTtcMin;
    }
    public void setMontantTtcMin(String montantTtcMin){
        this.montantTtcMin = montantTtcMin;
    }
    public String getMontantTtcMax(){
        return this.montantTtcMax;
    }
    public void setMontantTtcMax(String montantTtcMax){
        this.montantTtcMax = montantTtcMax;
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
    public EtatAchatCriteria getEtatAchat(){
        return this.etatAchat;
    }

    public void setEtatAchat(EtatAchatCriteria etatAchat){
        this.etatAchat = etatAchat;
    }
    public List<EtatAchatCriteria> getEtatAchats(){
        return this.etatAchats;
    }

    public void setEtatAchats(List<EtatAchatCriteria> etatAchats){
        this.etatAchats = etatAchats;
    }
}
