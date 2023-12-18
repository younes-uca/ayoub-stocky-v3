package  ma.zs.easystock.ws.dto.gestionchequeffet;

import ma.zs.easystock.zynerator.audit.Log;
import ma.zs.easystock.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Date;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.easystock.ws.dto.commun.DepotDto;
import ma.zs.easystock.ws.dto.stock.ProduitDto;
import ma.zs.easystock.ws.dto.Transfert.RaisonDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransfertDto  extends AuditBaseDto {

    private String reference  ;
    private String dateTransfert ;
    private String description  ;

    private RaisonDto raison ;

    private List<TransfertItemDto> transfertItems ;


    public TransfertDto(){
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
    public String getDateTransfert(){
        return this.dateTransfert;
    }
    public void setDateTransfert(String dateTransfert){
        this.dateTransfert = dateTransfert;
    }

    @Log
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }


    public RaisonDto getRaison(){
        return this.raison;
    }

    public void setRaison(RaisonDto raison){
        this.raison = raison;
    }



    public List<TransfertItemDto> getTransfertItems(){
        return this.transfertItems;
    }

    public void setTransfertItems(List<TransfertItemDto> transfertItems){
        this.transfertItems = transfertItems;
    }



}
