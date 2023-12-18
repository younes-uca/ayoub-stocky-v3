package  ma.zs.easystock.dao.specification.core.gestionchequeffet;

import ma.zs.easystock.dao.criteria.core.gestionchequeffet.EtatTransactionCriteria;
import ma.zs.easystock.bean.core.gestionchequeffet.EtatTransaction;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class EtatTransactionSpecification extends  AbstractSpecification<EtatTransactionCriteria, EtatTransaction>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public EtatTransactionSpecification(EtatTransactionCriteria criteria) {
        super(criteria);
    }

    public EtatTransactionSpecification(EtatTransactionCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
