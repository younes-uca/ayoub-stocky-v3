package  ma.zs.easystock.dao.specification.core.entree;

import ma.zs.easystock.dao.criteria.core.entree.SortieProduitCriteria;
import ma.zs.easystock.bean.core.entree.SortieProduit;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class SortieProduitSpecification extends  AbstractSpecification<SortieProduitCriteria, SortieProduit>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("reference", criteria.getReference(),criteria.getReferenceLike());
        addPredicate("dateSortieProduit", criteria.getDateSortieProduit(), criteria.getDateSortieProduitFrom(), criteria.getDateSortieProduitTo());
        addPredicateFk("depot","id", criteria.getDepot()==null?null:criteria.getDepot().getId());
        addPredicateFk("depot","id", criteria.getDepots());
    }

    public SortieProduitSpecification(SortieProduitCriteria criteria) {
        super(criteria);
    }

    public SortieProduitSpecification(SortieProduitCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
