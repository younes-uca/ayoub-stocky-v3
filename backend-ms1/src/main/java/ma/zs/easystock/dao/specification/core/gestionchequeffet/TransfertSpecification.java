package  ma.zs.easystock.dao.specification.core.gestionchequeffet;

import ma.zs.easystock.dao.criteria.core.gestionchequeffet.TransfertCriteria;
import ma.zs.easystock.bean.core.gestionchequeffet.Transfert;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class TransfertSpecification extends  AbstractSpecification<TransfertCriteria, Transfert>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("reference", criteria.getReference(),criteria.getReferenceLike());
        addPredicate("dateTransfert", criteria.getDateTransfert(), criteria.getDateTransfertFrom(), criteria.getDateTransfertTo());
        addPredicateFk("raison","id", criteria.getRaison()==null?null:criteria.getRaison().getId());
        addPredicateFk("raison","id", criteria.getRaisons());
    }

    public TransfertSpecification(TransfertCriteria criteria) {
        super(criteria);
    }

    public TransfertSpecification(TransfertCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
