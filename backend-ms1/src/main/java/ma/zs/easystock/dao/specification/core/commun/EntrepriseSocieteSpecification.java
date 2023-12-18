package  ma.zs.easystock.dao.specification.core.commun;

import ma.zs.easystock.dao.criteria.core.commun.EntrepriseSocieteCriteria;
import ma.zs.easystock.bean.core.commun.EntrepriseSociete;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class EntrepriseSocieteSpecification extends  AbstractSpecification<EntrepriseSocieteCriteria, EntrepriseSociete>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("nom", criteria.getNom(),criteria.getNomLike());
        addPredicate("ice", criteria.getIce(),criteria.getIceLike());
        addPredicateBigDecimal("capital", criteria.getCapital(), criteria.getCapitalMin(), criteria.getCapitalMax());
    }

    public EntrepriseSocieteSpecification(EntrepriseSocieteCriteria criteria) {
        super(criteria);
    }

    public EntrepriseSocieteSpecification(EntrepriseSocieteCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
