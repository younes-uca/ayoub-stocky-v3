package  ma.zs.easystock.dao.criteria.core.gestionchequeffet;



import ma.zs.easystock.zynerator.criteria.BaseCriteria;
import java.util.List;

public class CompteCriteria extends  BaseCriteria  {

    private String numeroCompte;
    private String numeroCompteLike;
    private String solde;
    private String soldeMin;
    private String soldeMax;

    private BanqueCriteria banque ;
    private List<BanqueCriteria> banques ;
    private ProprietaireCriteria proprietaire ;
    private List<ProprietaireCriteria> proprietaires ;


    public CompteCriteria(){}

    public String getNumeroCompte(){
        return this.numeroCompte;
    }
    public void setNumeroCompte(String numeroCompte){
        this.numeroCompte = numeroCompte;
    }
    public String getNumeroCompteLike(){
        return this.numeroCompteLike;
    }
    public void setNumeroCompteLike(String numeroCompteLike){
        this.numeroCompteLike = numeroCompteLike;
    }

    public String getSolde(){
        return this.solde;
    }
    public void setSolde(String solde){
        this.solde = solde;
    }   
    public String getSoldeMin(){
        return this.soldeMin;
    }
    public void setSoldeMin(String soldeMin){
        this.soldeMin = soldeMin;
    }
    public String getSoldeMax(){
        return this.soldeMax;
    }
    public void setSoldeMax(String soldeMax){
        this.soldeMax = soldeMax;
    }
      

    public BanqueCriteria getBanque(){
        return this.banque;
    }

    public void setBanque(BanqueCriteria banque){
        this.banque = banque;
    }
    public List<BanqueCriteria> getBanques(){
        return this.banques;
    }

    public void setBanques(List<BanqueCriteria> banques){
        this.banques = banques;
    }
    public ProprietaireCriteria getProprietaire(){
        return this.proprietaire;
    }

    public void setProprietaire(ProprietaireCriteria proprietaire){
        this.proprietaire = proprietaire;
    }
    public List<ProprietaireCriteria> getProprietaires(){
        return this.proprietaires;
    }

    public void setProprietaires(List<ProprietaireCriteria> proprietaires){
        this.proprietaires = proprietaires;
    }
}
