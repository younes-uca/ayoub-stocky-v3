package  ma.zs.easystock.dao.criteria.core.stock;


import ma.zs.easystock.dao.criteria.core.commun.ClientCriteria;
import ma.zs.easystock.dao.criteria.core.commun.EtatAvoirVenteCriteria;
import ma.zs.easystock.dao.criteria.core.commun.EntrepriseSocieteCriteria;

import ma.zs.easystock.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class AvoirVenteCriteria extends  BaseCriteria  {

    private String barCode;
    private String barCodeLike;
    private String codeAvoirVente;
    private String codeAvoirVenteLike;
    private String numeroFactureAvoirVente;
    private String numeroFactureAvoirVenteLike;
    private LocalDateTime dateFactureAvoirVente;
    private LocalDateTime dateFactureAvoirVenteFrom;
    private LocalDateTime dateFactureAvoirVenteTo;
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
    private EtatAvoirVenteCriteria etatAvoirVente ;
    private List<EtatAvoirVenteCriteria> etatAvoirVentes ;
    private VenteCriteria vente ;
    private List<VenteCriteria> ventes ;


    public AvoirVenteCriteria(){}

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

    public String getCodeAvoirVente(){
        return this.codeAvoirVente;
    }
    public void setCodeAvoirVente(String codeAvoirVente){
        this.codeAvoirVente = codeAvoirVente;
    }
    public String getCodeAvoirVenteLike(){
        return this.codeAvoirVenteLike;
    }
    public void setCodeAvoirVenteLike(String codeAvoirVenteLike){
        this.codeAvoirVenteLike = codeAvoirVenteLike;
    }

    public String getNumeroFactureAvoirVente(){
        return this.numeroFactureAvoirVente;
    }
    public void setNumeroFactureAvoirVente(String numeroFactureAvoirVente){
        this.numeroFactureAvoirVente = numeroFactureAvoirVente;
    }
    public String getNumeroFactureAvoirVenteLike(){
        return this.numeroFactureAvoirVenteLike;
    }
    public void setNumeroFactureAvoirVenteLike(String numeroFactureAvoirVenteLike){
        this.numeroFactureAvoirVenteLike = numeroFactureAvoirVenteLike;
    }

    public LocalDateTime getDateFactureAvoirVente(){
        return this.dateFactureAvoirVente;
    }
    public void setDateFactureAvoirVente(LocalDateTime dateFactureAvoirVente){
        this.dateFactureAvoirVente = dateFactureAvoirVente;
    }
    public LocalDateTime getDateFactureAvoirVenteFrom(){
        return this.dateFactureAvoirVenteFrom;
    }
    public void setDateFactureAvoirVenteFrom(LocalDateTime dateFactureAvoirVenteFrom){
        this.dateFactureAvoirVenteFrom = dateFactureAvoirVenteFrom;
    }
    public LocalDateTime getDateFactureAvoirVenteTo(){
        return this.dateFactureAvoirVenteTo;
    }
    public void setDateFactureAvoirVenteTo(LocalDateTime dateFactureAvoirVenteTo){
        this.dateFactureAvoirVenteTo = dateFactureAvoirVenteTo;
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
    public EtatAvoirVenteCriteria getEtatAvoirVente(){
        return this.etatAvoirVente;
    }

    public void setEtatAvoirVente(EtatAvoirVenteCriteria etatAvoirVente){
        this.etatAvoirVente = etatAvoirVente;
    }
    public List<EtatAvoirVenteCriteria> getEtatAvoirVentes(){
        return this.etatAvoirVentes;
    }

    public void setEtatAvoirVentes(List<EtatAvoirVenteCriteria> etatAvoirVentes){
        this.etatAvoirVentes = etatAvoirVentes;
    }
    public VenteCriteria getVente(){
        return this.vente;
    }

    public void setVente(VenteCriteria vente){
        this.vente = vente;
    }
    public List<VenteCriteria> getVentes(){
        return this.ventes;
    }

    public void setVentes(List<VenteCriteria> ventes){
        this.ventes = ventes;
    }
}
