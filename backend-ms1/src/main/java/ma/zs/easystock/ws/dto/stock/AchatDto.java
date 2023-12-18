package  ma.zs.easystock.ws.dto.stock;

import ma.zs.easystock.zynerator.audit.Log;
import ma.zs.easystock.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Date;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;


import ma.zs.easystock.ws.dto.commun.FournisseurDto;
import ma.zs.easystock.ws.dto.commun.EtatAchatDto;
import ma.zs.easystock.ws.dto.commun.EtatAvoirAchatDto;
import ma.zs.easystock.ws.dto.commun.DepotDto;
import ma.zs.easystock.ws.dto.commun.EntrepriseSocieteDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class AchatDto  extends AuditBaseDto {

    private String dateFacture ;
    private String referenceFacture  ;
    private BigDecimal montantHt  ;
    private BigDecimal montantTva  ;
    private BigDecimal montantTtc  ;
    private String description  ;

    private EntrepriseSocieteDto entrepriseSociete ;
    private FournisseurDto fournisseur ;
    private EtatAchatDto etatAchat ;

    private List<AchatItemDto> achatItems ;
    private List<AvoirAchatDto> avoirAchats ;


    public AchatDto(){
        super();
    }



    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateFacture(){
        return this.dateFacture;
    }
    public void setDateFacture(String dateFacture){
        this.dateFacture = dateFacture;
    }

    @Log
    public String getReferenceFacture(){
        return this.referenceFacture;
    }
    public void setReferenceFacture(String referenceFacture){
        this.referenceFacture = referenceFacture;
    }

    @Log
    public BigDecimal getMontantHt(){
        return this.montantHt;
    }
    public void setMontantHt(BigDecimal montantHt){
        this.montantHt = montantHt;
    }

    @Log
    public BigDecimal getMontantTva(){
        return this.montantTva;
    }
    public void setMontantTva(BigDecimal montantTva){
        this.montantTva = montantTva;
    }

    @Log
    public BigDecimal getMontantTtc(){
        return this.montantTtc;
    }
    public void setMontantTtc(BigDecimal montantTtc){
        this.montantTtc = montantTtc;
    }

    @Log
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }


    public EntrepriseSocieteDto getEntrepriseSociete(){
        return this.entrepriseSociete;
    }

    public void setEntrepriseSociete(EntrepriseSocieteDto entrepriseSociete){
        this.entrepriseSociete = entrepriseSociete;
    }
    public FournisseurDto getFournisseur(){
        return this.fournisseur;
    }

    public void setFournisseur(FournisseurDto fournisseur){
        this.fournisseur = fournisseur;
    }
    public EtatAchatDto getEtatAchat(){
        return this.etatAchat;
    }

    public void setEtatAchat(EtatAchatDto etatAchat){
        this.etatAchat = etatAchat;
    }



    public List<AchatItemDto> getAchatItems(){
        return this.achatItems;
    }

    public void setAchatItems(List<AchatItemDto> achatItems){
        this.achatItems = achatItems;
    }
    public List<AvoirAchatDto> getAvoirAchats(){
        return this.avoirAchats;
    }

    public void setAvoirAchats(List<AvoirAchatDto> avoirAchats){
        this.avoirAchats = avoirAchats;
    }



}
