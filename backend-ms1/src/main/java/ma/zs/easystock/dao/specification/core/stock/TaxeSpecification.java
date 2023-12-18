package  ma.zs.easystock.dao.specification.core.stock;

import ma.zs.easystock.dao.criteria.core.stock.TaxeCriteria;
import ma.zs.easystock.bean.core.stock.Taxe;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class TaxeSpecification extends  AbstractSpecification<TaxeCriteria, Taxe>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicateBigDecimal("montant", criteria.getMontant(), criteria.getMontantMin(), criteria.getMontantMax());
    }

    public TaxeSpecification(TaxeCriteria criteria) {
        super(criteria);
    }

    public TaxeSpecification(TaxeCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
