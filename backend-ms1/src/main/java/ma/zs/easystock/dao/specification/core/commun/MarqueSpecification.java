package  ma.zs.easystock.dao.specification.core.commun;

import ma.zs.easystock.dao.criteria.core.commun.MarqueCriteria;
import ma.zs.easystock.bean.core.commun.Marque;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class MarqueSpecification extends  AbstractSpecification<MarqueCriteria, Marque>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public MarqueSpecification(MarqueCriteria criteria) {
        super(criteria);
    }

    public MarqueSpecification(MarqueCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
