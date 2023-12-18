package  ma.zs.easystock.ws.dto.stock;

import ma.zs.easystock.zynerator.audit.Log;
import ma.zs.easystock.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;


import ma.zs.easystock.ws.dto.entree.EntreeProduitDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class EntreeProduitItemDto  extends AuditBaseDto {

    private BigDecimal quantite  ;
    private String description  ;

    private ProduitDto produit ;
    private EntreeProduitDto entreeProduit ;



    public EntreeProduitItemDto(){
        super();
    }



    @Log
    public BigDecimal getQuantite(){
        return this.quantite;
    }
    public void setQuantite(BigDecimal quantite){
        this.quantite = quantite;
    }

    @Log
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }


    public ProduitDto getProduit(){
        return this.produit;
    }

    public void setProduit(ProduitDto produit){
        this.produit = produit;
    }
    public EntreeProduitDto getEntreeProduit(){
        return this.entreeProduit;
    }

    public void setEntreeProduit(EntreeProduitDto entreeProduit){
        this.entreeProduit = entreeProduit;
    }






}
