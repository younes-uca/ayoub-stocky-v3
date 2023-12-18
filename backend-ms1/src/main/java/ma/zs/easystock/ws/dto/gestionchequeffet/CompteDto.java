package  ma.zs.easystock.ws.dto.gestionchequeffet;

import ma.zs.easystock.zynerator.audit.Log;
import ma.zs.easystock.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;




@JsonInclude(JsonInclude.Include.NON_NULL)
public class CompteDto  extends AuditBaseDto {

    private String numeroCompte  ;
    private BigDecimal solde  ;

    private BanqueDto banque ;
    private ProprietaireDto proprietaire ;



    public CompteDto(){
        super();
    }



    @Log
    public String getNumeroCompte(){
        return this.numeroCompte;
    }
    public void setNumeroCompte(String numeroCompte){
        this.numeroCompte = numeroCompte;
    }

    @Log
    public BigDecimal getSolde(){
        return this.solde;
    }
    public void setSolde(BigDecimal solde){
        this.solde = solde;
    }


    public BanqueDto getBanque(){
        return this.banque;
    }

    public void setBanque(BanqueDto banque){
        this.banque = banque;
    }
    public ProprietaireDto getProprietaire(){
        return this.proprietaire;
    }

    public void setProprietaire(ProprietaireDto proprietaire){
        this.proprietaire = proprietaire;
    }






}
