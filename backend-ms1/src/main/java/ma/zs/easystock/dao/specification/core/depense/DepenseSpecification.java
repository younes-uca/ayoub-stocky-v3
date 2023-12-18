package  ma.zs.easystock.dao.specification.core.depense;

import ma.zs.easystock.dao.criteria.core.depense.DepenseCriteria;
import ma.zs.easystock.bean.core.depense.Depense;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class DepenseSpecification extends  AbstractSpecification<DepenseCriteria, Depense>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("dateDepense", criteria.getDateDepense(), criteria.getDateDepenseFrom(), criteria.getDateDepenseTo());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicateBigDecimal("montant", criteria.getMontant(), criteria.getMontantMin(), criteria.getMontantMax());
    }

    public DepenseSpecification(DepenseCriteria criteria) {
        super(criteria);
    }

    public DepenseSpecification(DepenseCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
