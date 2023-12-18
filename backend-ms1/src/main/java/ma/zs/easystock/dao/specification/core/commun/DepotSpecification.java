package  ma.zs.easystock.dao.specification.core.commun;

import ma.zs.easystock.dao.criteria.core.commun.DepotCriteria;
import ma.zs.easystock.bean.core.commun.Depot;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class DepotSpecification extends  AbstractSpecification<DepotCriteria, Depot>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicate("adresse", criteria.getAdresse(),criteria.getAdresseLike());
    }

    public DepotSpecification(DepotCriteria criteria) {
        super(criteria);
    }

    public DepotSpecification(DepotCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
