package  ma.zs.easystock.dao.criteria.core.gestionchequeffet;



import ma.zs.easystock.zynerator.criteria.BaseCriteria;
import java.util.List;

public class ProprietaireBanqueCriteria extends  BaseCriteria  {


    private ProprietaireCriteria proprietaire ;
    private List<ProprietaireCriteria> proprietaires ;
    private BanqueCriteria banque ;
    private List<BanqueCriteria> banques ;
    private CompteCriteria compte ;
    private List<CompteCriteria> comptes ;


    public ProprietaireBanqueCriteria(){}


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
    public CompteCriteria getCompte(){
        return this.compte;
    }

    public void setCompte(CompteCriteria compte){
        this.compte = compte;
    }
    public List<CompteCriteria> getComptes(){
        return this.comptes;
    }

    public void setComptes(List<CompteCriteria> comptes){
        this.comptes = comptes;
    }
}
