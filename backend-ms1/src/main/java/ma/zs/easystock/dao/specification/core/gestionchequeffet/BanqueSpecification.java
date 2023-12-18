package  ma.zs.easystock.dao.specification.core.gestionchequeffet;

import ma.zs.easystock.dao.criteria.core.gestionchequeffet.BanqueCriteria;
import ma.zs.easystock.bean.core.gestionchequeffet.Banque;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class BanqueSpecification extends  AbstractSpecification<BanqueCriteria, Banque>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public BanqueSpecification(BanqueCriteria criteria) {
        super(criteria);
    }

    public BanqueSpecification(BanqueCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
