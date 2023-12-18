package  ma.zs.easystock.dao.specification.core.gestionchequeffet;

import ma.zs.easystock.dao.criteria.core.gestionchequeffet.TypeTransactionCriteria;
import ma.zs.easystock.bean.core.gestionchequeffet.TypeTransaction;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class TypeTransactionSpecification extends  AbstractSpecification<TypeTransactionCriteria, TypeTransaction>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public TypeTransactionSpecification(TypeTransactionCriteria criteria) {
        super(criteria);
    }

    public TypeTransactionSpecification(TypeTransactionCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
