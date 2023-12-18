package  ma.zs.easystock.ws.dto.stock;

import ma.zs.easystock.zynerator.audit.Log;
import ma.zs.easystock.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Date;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.easystock.ws.dto.commun.DepotDto;
import ma.zs.easystock.ws.dto.commun.EntrepriseSocieteDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class InventaireDto  extends AuditBaseDto {

    private String reference  ;
    private String dateInventaire ;
    private String description  ;

    private EntrepriseSocieteDto entrepriseSociete ;
    private DepotDto depot ;

    private List<InventaireItemDto> inventaireItems ;


    public InventaireDto(){
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
    public String getDateInventaire(){
        return this.dateInventaire;
    }
    public void setDateInventaire(String dateInventaire){
        this.dateInventaire = dateInventaire;
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
    public DepotDto getDepot(){
        return this.depot;
    }

    public void setDepot(DepotDto depot){
        this.depot = depot;
    }



    public List<InventaireItemDto> getInventaireItems(){
        return this.inventaireItems;
    }

    public void setInventaireItems(List<InventaireItemDto> inventaireItems){
        this.inventaireItems = inventaireItems;
    }



}
