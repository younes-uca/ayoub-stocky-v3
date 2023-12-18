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
import ma.zs.easystock.ws.dto.commun.DepotDto;
import ma.zs.easystock.ws.dto.commun.EtatAvoirAchatDto;
import ma.zs.easystock.ws.dto.commun.EntrepriseSocieteDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class AvoirAchatDto  extends AuditBaseDto {

    private String barCode  ;
    private String codeAvoirAchat  ;
    private String numeroFactureAvoirFournisseur  ;
    private String dateFactureAvoirFournisseur ;
    private BigDecimal montantHt  ;
    private BigDecimal montantTva  ;
    private BigDecimal montantTtc  ;
    private String description  ;

    private EntrepriseSocieteDto entrepriseSociete ;
    private FournisseurDto fournisseur ;
    private EtatAvoirAchatDto etatAvoirAchat ;
    private AchatDto achat ;

    private List<AvoirAchatItemDto> avoirAchatItems ;


    public AvoirAchatDto(){
        super();
    }



    @Log
    public String getBarCode(){
        return this.barCode;
    }
    public void setBarCode(String barCode){
        this.barCode = barCode;
    }

    @Log
    public String getCodeAvoirAchat(){
        return this.codeAvoirAchat;
    }
    public void setCodeAvoirAchat(String codeAvoirAchat){
        this.codeAvoirAchat = codeAvoirAchat;
    }

    @Log
    public String getNumeroFactureAvoirFournisseur(){
        return this.numeroFactureAvoirFournisseur;
    }
    public void setNumeroFactureAvoirFournisseur(String numeroFactureAvoirFournisseur){
        this.numeroFactureAvoirFournisseur = numeroFactureAvoirFournisseur;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateFactureAvoirFournisseur(){
        return this.dateFactureAvoirFournisseur;
    }
    public void setDateFactureAvoirFournisseur(String dateFactureAvoirFournisseur){
        this.dateFactureAvoirFournisseur = dateFactureAvoirFournisseur;
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
    public EtatAvoirAchatDto getEtatAvoirAchat(){
        return this.etatAvoirAchat;
    }

    public void setEtatAvoirAchat(EtatAvoirAchatDto etatAvoirAchat){
        this.etatAvoirAchat = etatAvoirAchat;
    }
    public AchatDto getAchat(){
        return this.achat;
    }

    public void setAchat(AchatDto achat){
        this.achat = achat;
    }



    public List<AvoirAchatItemDto> getAvoirAchatItems(){
        return this.avoirAchatItems;
    }

    public void setAvoirAchatItems(List<AvoirAchatItemDto> avoirAchatItems){
        this.avoirAchatItems = avoirAchatItems;
    }



}
