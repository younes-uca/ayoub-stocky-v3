package  ma.zs.easystock.dao.criteria.core.stock;


import ma.zs.easystock.dao.criteria.core.commun.EtatVenteCriteria;
import ma.zs.easystock.dao.criteria.core.commun.ClientCriteria;
import ma.zs.easystock.dao.criteria.core.commun.EntrepriseSocieteCriteria;

import ma.zs.easystock.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class VenteCriteria extends  BaseCriteria  {

    private String barCode;
    private String barCodeLike;
    private String codeVente;
    private String codeVenteLike;
    private LocalDateTime dateFacture;
    private LocalDateTime dateFactureFrom;
    private LocalDateTime dateFactureTo;
    private String numeroFacture;
    private String numeroFactureLike;
    private String montantHt;
    private String montantHtMin;
    private String montantHtMax;
    private String montantTva;
    private String montantTvaMin;
    private String montantTvaMax;
    private String montantTtc;
    private String montantTtcMin;
    private String montantTtcMax;
    private String description;
    private String descriptionLike;

    private EntrepriseSocieteCriteria entrepriseSociete ;
    private List<EntrepriseSocieteCriteria> entrepriseSocietes ;
    private ClientCriteria client ;
    private List<ClientCriteria> clients ;
    private EtatVenteCriteria etatVente ;
    private List<EtatVenteCriteria> etatVentes ;


    public VenteCriteria(){}

    public String getBarCode(){
        return this.barCode;
    }
    public void setBarCode(String barCode){
        this.barCode = barCode;
    }
    public String getBarCodeLike(){
        return this.barCodeLike;
    }
    public void setBarCodeLike(String barCodeLike){
        this.barCodeLike = barCodeLike;
    }

    public String getCodeVente(){
        return this.codeVente;
    }
    public void setCodeVente(String codeVente){
        this.codeVente = codeVente;
    }
    public String getCodeVenteLike(){
        return this.codeVenteLike;
    }
    public void setCodeVenteLike(String codeVenteLike){
        this.codeVenteLike = codeVenteLike;
    }

    public LocalDateTime getDateFacture(){
        return this.dateFacture;
    }
    public void setDateFacture(LocalDateTime dateFacture){
        this.dateFacture = dateFacture;
    }
    public LocalDateTime getDateFactureFrom(){
        return this.dateFactureFrom;
    }
    public void setDateFactureFrom(LocalDateTime dateFactureFrom){
        this.dateFactureFrom = dateFactureFrom;
    }
    public LocalDateTime getDateFactureTo(){
        return this.dateFactureTo;
    }
    public void setDateFactureTo(LocalDateTime dateFactureTo){
        this.dateFactureTo = dateFactureTo;
    }
    public String getNumeroFacture(){
        return this.numeroFacture;
    }
    public void setNumeroFacture(String numeroFacture){
        this.numeroFacture = numeroFacture;
    }
    public String getNumeroFactureLike(){
        return this.numeroFactureLike;
    }
    public void setNumeroFactureLike(String numeroFactureLike){
        this.numeroFactureLike = numeroFactureLike;
    }

    public String getMontantHt(){
        return this.montantHt;
    }
    public void setMontantHt(String montantHt){
        this.montantHt = montantHt;
    }   
    public String getMontantHtMin(){
        return this.montantHtMin;
    }
    public void setMontantHtMin(String montantHtMin){
        this.montantHtMin = montantHtMin;
    }
    public String getMontantHtMax(){
        return this.montantHtMax;
    }
    public void setMontantHtMax(String montantHtMax){
        this.montantHtMax = montantHtMax;
    }
      
    public String getMontantTva(){
        return this.montantTva;
    }
    public void setMontantTva(String montantTva){
        this.montantTva = montantTva;
    }   
    public String getMontantTvaMin(){
        return this.montantTvaMin;
    }
    public void setMontantTvaMin(String montantTvaMin){
        this.montantTvaMin = montantTvaMin;
    }
    public String getMontantTvaMax(){
        return this.montantTvaMax;
    }
    public void setMontantTvaMax(String montantTvaMax){
        this.montantTvaMax = montantTvaMax;
    }
      
    public String getMontantTtc(){
        return this.montantTtc;
    }
    public void setMontantTtc(String montantTtc){
        this.montantTtc = montantTtc;
    }   
    public String getMontantTtcMin(){
        return this.montantTtcMin;
    }
    public void setMontantTtcMin(String montantTtcMin){
        this.montantTtcMin = montantTtcMin;
    }
    public String getMontantTtcMax(){
        return this.montantTtcMax;
    }
    public void setMontantTtcMax(String montantTtcMax){
        this.montantTtcMax = montantTtcMax;
    }
      
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescriptionLike(){
        return this.descriptionLike;
    }
    public void setDescriptionLike(String descriptionLike){
        this.descriptionLike = descriptionLike;
    }


    public EntrepriseSocieteCriteria getEntrepriseSociete(){
        return this.entrepriseSociete;
    }

    public void setEntrepriseSociete(EntrepriseSocieteCriteria entrepriseSociete){
        this.entrepriseSociete = entrepriseSociete;
    }
    public List<EntrepriseSocieteCriteria> getEntrepriseSocietes(){
        return this.entrepriseSocietes;
    }

    public void setEntrepriseSocietes(List<EntrepriseSocieteCriteria> entrepriseSocietes){
        this.entrepriseSocietes = entrepriseSocietes;
    }
    public ClientCriteria getClient(){
        return this.client;
    }

    public void setClient(ClientCriteria client){
        this.client = client;
    }
    public List<ClientCriteria> getClients(){
        return this.clients;
    }

    public void setClients(List<ClientCriteria> clients){
        this.clients = clients;
    }
    public EtatVenteCriteria getEtatVente(){
        return this.etatVente;
    }

    public void setEtatVente(EtatVenteCriteria etatVente){
        this.etatVente = etatVente;
    }
    public List<EtatVenteCriteria> getEtatVentes(){
        return this.etatVentes;
    }

    public void setEtatVentes(List<EtatVenteCriteria> etatVentes){
        this.etatVentes = etatVentes;
    }
}
