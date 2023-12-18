package  ma.zs.easystock.ws.dto.stock;

import ma.zs.easystock.zynerator.audit.Log;
import ma.zs.easystock.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.math.BigDecimal;


import ma.zs.easystock.ws.dto.commun.DepotDto;
import ma.zs.easystock.ws.dto.commun.MarqueDto;
import ma.zs.easystock.ws.dto.commun.CategorieDto;
import ma.zs.easystock.ws.dto.commun.EntrepriseSocieteDto;
import ma.zs.easystock.ws.dto.commun.UniteMesureDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProduitDto  extends AuditBaseDto {

    private String reference  ;
    private String barCode  ;
    private String designation  ;
    private BigDecimal quantite  ;
    private BigDecimal prixAchatMoyen  ;
    private BigDecimal prixVente  ;
    private String pathPhoto  ;
    private BigDecimal seuilAlerte  ;
    private String description  ;

    private EntrepriseSocieteDto entrepriseSociete ;
    private CategorieDto categorie ;
    private MarqueDto marque ;
    private UniteMesureDto uniteMesure ;

    private List<StockDto> stocks ;


    public ProduitDto(){
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
    public String getBarCode(){
        return this.barCode;
    }
    public void setBarCode(String barCode){
        this.barCode = barCode;
    }

    @Log
    public String getDesignation(){
        return this.designation;
    }
    public void setDesignation(String designation){
        this.designation = designation;
    }

    @Log
    public BigDecimal getQuantite(){
        return this.quantite;
    }
    public void setQuantite(BigDecimal quantite){
        this.quantite = quantite;
    }

    @Log
    public BigDecimal getPrixAchatMoyen(){
        return this.prixAchatMoyen;
    }
    public void setPrixAchatMoyen(BigDecimal prixAchatMoyen){
        this.prixAchatMoyen = prixAchatMoyen;
    }

    @Log
    public BigDecimal getPrixVente(){
        return this.prixVente;
    }
    public void setPrixVente(BigDecimal prixVente){
        this.prixVente = prixVente;
    }

    @Log
    public String getPathPhoto(){
        return this.pathPhoto;
    }
    public void setPathPhoto(String pathPhoto){
        this.pathPhoto = pathPhoto;
    }

    @Log
    public BigDecimal getSeuilAlerte(){
        return this.seuilAlerte;
    }
    public void setSeuilAlerte(BigDecimal seuilAlerte){
        this.seuilAlerte = seuilAlerte;
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
    public CategorieDto getCategorie(){
        return this.categorie;
    }

    public void setCategorie(CategorieDto categorie){
        this.categorie = categorie;
    }
    public MarqueDto getMarque(){
        return this.marque;
    }

    public void setMarque(MarqueDto marque){
        this.marque = marque;
    }
    public UniteMesureDto getUniteMesure(){
        return this.uniteMesure;
    }

    public void setUniteMesure(UniteMesureDto uniteMesure){
        this.uniteMesure = uniteMesure;
    }



    public List<StockDto> getStocks(){
        return this.stocks;
    }

    public void setStocks(List<StockDto> stocks){
        this.stocks = stocks;
    }



}
