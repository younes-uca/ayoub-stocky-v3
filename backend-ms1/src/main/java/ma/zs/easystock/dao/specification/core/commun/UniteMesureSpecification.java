package  ma.zs.easystock.dao.specification.core.commun;

import ma.zs.easystock.dao.criteria.core.commun.UniteMesureCriteria;
import ma.zs.easystock.bean.core.commun.UniteMesure;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class UniteMesureSpecification extends  AbstractSpecification<UniteMesureCriteria, UniteMesure>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public UniteMesureSpecification(UniteMesureCriteria criteria) {
        super(criteria);
    }

    public UniteMesureSpecification(UniteMesureCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
