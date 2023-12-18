package  ma.zs.easystock.dao.specification.core.gestionchequeffet;

import ma.zs.easystock.dao.criteria.core.gestionchequeffet.ModeReglementCriteria;
import ma.zs.easystock.bean.core.gestionchequeffet.ModeReglement;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class ModeReglementSpecification extends  AbstractSpecification<ModeReglementCriteria, ModeReglement>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public ModeReglementSpecification(ModeReglementCriteria criteria) {
        super(criteria);
    }

    public ModeReglementSpecification(ModeReglementCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
