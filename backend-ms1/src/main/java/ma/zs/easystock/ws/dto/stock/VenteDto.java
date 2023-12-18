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


import ma.zs.easystock.ws.dto.commun.ClientDto;
import ma.zs.easystock.ws.dto.reglement.ReglementVenteDto;
import ma.zs.easystock.ws.dto.gestionchequeffet.ModeReglementDto;
import ma.zs.easystock.ws.dto.commun.EtatVenteDto;
import ma.zs.easystock.ws.dto.commun.DepotDto;
import ma.zs.easystock.ws.dto.commun.EtatAvoirVenteDto;
import ma.zs.easystock.ws.dto.commun.EntrepriseSocieteDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class VenteDto  extends AuditBaseDto {

    private String barCode  ;
    private String codeVente  ;
    private String dateFacture ;
    private String numeroFacture  ;
    private BigDecimal montantHt  ;
    private BigDecimal montantTva  ;
    private BigDecimal montantTtc  ;
    private String description  ;

    private EntrepriseSocieteDto entrepriseSociete ;
    private ClientDto client ;
    private EtatVenteDto etatVente ;

    private List<VenteItemDto> venteItems ;
    private List<AvoirVenteDto> avoirVentes ;
    private List<ReglementVenteDto> reglementVentes ;


    public VenteDto(){
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
    public String getCodeVente(){
        return this.codeVente;
    }
    public void setCodeVente(String codeVente){
        this.codeVente = codeVente;
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
    public String getNumeroFacture(){
        return this.numeroFacture;
    }
    public void setNumeroFacture(String numeroFacture){
        this.numeroFacture = numeroFacture;
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
    public ClientDto getClient(){
        return this.client;
    }

    public void setClient(ClientDto client){
        this.client = client;
    }
    public EtatVenteDto getEtatVente(){
        return this.etatVente;
    }

    public void setEtatVente(EtatVenteDto etatVente){
        this.etatVente = etatVente;
    }



    public List<VenteItemDto> getVenteItems(){
        return this.venteItems;
    }

    public void setVenteItems(List<VenteItemDto> venteItems){
        this.venteItems = venteItems;
    }
    public List<AvoirVenteDto> getAvoirVentes(){
        return this.avoirVentes;
    }

    public void setAvoirVentes(List<AvoirVenteDto> avoirVentes){
        this.avoirVentes = avoirVentes;
    }
    public List<ReglementVenteDto> getReglementVentes(){
        return this.reglementVentes;
    }

    public void setReglementVentes(List<ReglementVenteDto> reglementVentes){
        this.reglementVentes = reglementVentes;
    }



}
