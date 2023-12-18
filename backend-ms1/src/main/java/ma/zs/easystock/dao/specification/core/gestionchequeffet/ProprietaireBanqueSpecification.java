package  ma.zs.easystock.dao.specification.core.gestionchequeffet;

import ma.zs.easystock.dao.criteria.core.gestionchequeffet.ProprietaireBanqueCriteria;
import ma.zs.easystock.bean.core.gestionchequeffet.ProprietaireBanque;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class ProprietaireBanqueSpecification extends  AbstractSpecification<ProprietaireBanqueCriteria, ProprietaireBanque>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateFk("proprietaire","id", criteria.getProprietaire()==null?null:criteria.getProprietaire().getId());
        addPredicateFk("proprietaire","id", criteria.getProprietaires());
        addPredicateFk("proprietaire","telephone", criteria.getProprietaire()==null?null:criteria.getProprietaire().getTelephone());
        addPredicateFk("banque","id", criteria.getBanque()==null?null:criteria.getBanque().getId());
        addPredicateFk("banque","id", criteria.getBanques());
        addPredicateFk("compte","id", criteria.getCompte()==null?null:criteria.getCompte().getId());
        addPredicateFk("compte","id", criteria.getComptes());
    }

    public ProprietaireBanqueSpecification(ProprietaireBanqueCriteria criteria) {
        super(criteria);
    }

    public ProprietaireBanqueSpecification(ProprietaireBanqueCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
