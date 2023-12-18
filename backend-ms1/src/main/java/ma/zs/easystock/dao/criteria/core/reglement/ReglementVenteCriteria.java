package  ma.zs.easystock.dao.criteria.core.reglement;


import ma.zs.easystock.dao.criteria.core.gestionchequeffet.ModeReglementCriteria;
import ma.zs.easystock.dao.criteria.core.stock.VenteCriteria;

import ma.zs.easystock.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class ReglementVenteCriteria extends  BaseCriteria  {

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

    private VenteCriteria vente ;
    private List<VenteCriteria> ventes ;
    private ModeReglementCriteria modeReglement ;
    private List<ModeReglementCriteria> modeReglements ;


    public ReglementVenteCriteria(){}

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


    public VenteCriteria getVente(){
        return this.vente;
    }

    public void setVente(VenteCriteria vente){
        this.vente = vente;
    }
    public List<VenteCriteria> getVentes(){
        return this.ventes;
    }

    public void setVentes(List<VenteCriteria> ventes){
        this.ventes = ventes;
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
