package  ma.zs.easystock.ws.dto.reglement;

import ma.zs.easystock.zynerator.audit.Log;
import ma.zs.easystock.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;


import ma.zs.easystock.ws.dto.stock.AchatDto;
import ma.zs.easystock.ws.dto.gestionchequeffet.ModeReglementDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReglementAchatDto  extends AuditBaseDto {

    private String reference  ;
    private String dateReglement ;
    private BigDecimal montant  ;
    private String description  ;

    private AchatDto achat ;
    private ModeReglementDto modeReglement ;



    public ReglementAchatDto(){
        super();
    }



    @Log
    public String getReference(){
        return this.reference;
    }
    public void setReference(String reference){
        this.reference = reference;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateReglement(){
        return this.dateReglement;
    }
    public void setDateReglement(String dateReglement){
        this.dateReglement = dateReglement;
    }

    @Log
    public BigDecimal getMontant(){
        return this.montant;
    }
    public void setMontant(BigDecimal montant){
        this.montant = montant;
    }

    @Log
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }


    public AchatDto getAchat(){
        return this.achat;
    }

    public void setAchat(AchatDto achat){
        this.achat = achat;
    }
    public ModeReglementDto getModeReglement(){
        return this.modeReglement;
    }

    public void setModeReglement(ModeReglementDto modeReglement){
        this.modeReglement = modeReglement;
    }






}
