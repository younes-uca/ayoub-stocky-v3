package  ma.zs.easystock.dao.specification.core.Transfert;

import ma.zs.easystock.dao.criteria.core.Transfert.RaisonCriteria;
import ma.zs.easystock.bean.core.Transfert.Raison;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class RaisonSpecification extends  AbstractSpecification<RaisonCriteria, Raison>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public RaisonSpecification(RaisonCriteria criteria) {
        super(criteria);
    }

    public RaisonSpecification(RaisonCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
