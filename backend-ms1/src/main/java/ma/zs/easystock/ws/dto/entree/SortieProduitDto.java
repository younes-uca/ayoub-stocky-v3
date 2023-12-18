package  ma.zs.easystock.ws.dto.entree;

import ma.zs.easystock.zynerator.audit.Log;
import ma.zs.easystock.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Date;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.easystock.ws.dto.commun.DepotDto;
import ma.zs.easystock.ws.dto.stock.SortieProduitItemDto;
import ma.zs.easystock.ws.dto.stock.ProduitDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class SortieProduitDto  extends AuditBaseDto {

    private String reference  ;
    private String dateSortieProduit ;
    private String description  ;

    private DepotDto depot ;

    private List<SortieProduitItemDto> sortieProduitItems ;


    public SortieProduitDto(){
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
    public String getDateSortieProduit(){
        return this.dateSortieProduit;
    }
    public void setDateSortieProduit(String dateSortieProduit){
        this.dateSortieProduit = dateSortieProduit;
    }

    @Log
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }


    public DepotDto getDepot(){
        return this.depot;
    }

    public void setDepot(DepotDto depot){
        this.depot = depot;
    }



    public List<SortieProduitItemDto> getSortieProduitItems(){
        return this.sortieProduitItems;
    }

    public void setSortieProduitItems(List<SortieProduitItemDto> sortieProduitItems){
        this.sortieProduitItems = sortieProduitItems;
    }



}
