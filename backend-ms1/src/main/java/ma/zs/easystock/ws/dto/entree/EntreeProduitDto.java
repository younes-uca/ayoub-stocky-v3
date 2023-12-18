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
import ma.zs.easystock.ws.dto.stock.ProduitDto;
import ma.zs.easystock.ws.dto.commun.FournisseurDto;
import ma.zs.easystock.ws.dto.stock.EntreeProduitItemDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class EntreeProduitDto  extends AuditBaseDto {

    private String reference  ;
    private String dateEntreeProduit ;
    private String description  ;

    private FournisseurDto fournisseur ;
    private DepotDto depot ;

    private List<EntreeProduitItemDto> entreeProduitItems ;


    public EntreeProduitDto(){
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
    public String getDateEntreeProduit(){
        return this.dateEntreeProduit;
    }
    public void setDateEntreeProduit(String dateEntreeProduit){
        this.dateEntreeProduit = dateEntreeProduit;
    }

    @Log
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }


    public FournisseurDto getFournisseur(){
        return this.fournisseur;
    }

    public void setFournisseur(FournisseurDto fournisseur){
        this.fournisseur = fournisseur;
    }
    public DepotDto getDepot(){
        return this.depot;
    }

    public void setDepot(DepotDto depot){
        this.depot = depot;
    }



    public List<EntreeProduitItemDto> getEntreeProduitItems(){
        return this.entreeProduitItems;
    }

    public void setEntreeProduitItems(List<EntreeProduitItemDto> entreeProduitItems){
        this.entreeProduitItems = entreeProduitItems;
    }



}
