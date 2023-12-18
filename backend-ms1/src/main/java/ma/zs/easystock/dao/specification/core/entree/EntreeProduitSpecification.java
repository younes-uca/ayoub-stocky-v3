package  ma.zs.easystock.dao.specification.core.entree;

import ma.zs.easystock.dao.criteria.core.entree.EntreeProduitCriteria;
import ma.zs.easystock.bean.core.entree.EntreeProduit;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class EntreeProduitSpecification extends  AbstractSpecification<EntreeProduitCriteria, EntreeProduit>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("reference", criteria.getReference(),criteria.getReferenceLike());
        addPredicate("dateEntreeProduit", criteria.getDateEntreeProduit(), criteria.getDateEntreeProduitFrom(), criteria.getDateEntreeProduitTo());
        addPredicateFk("fournisseur","id", criteria.getFournisseur()==null?null:criteria.getFournisseur().getId());
        addPredicateFk("fournisseur","id", criteria.getFournisseurs());
        addPredicateFk("fournisseur","telephone", criteria.getFournisseur()==null?null:criteria.getFournisseur().getTelephone());
        addPredicateFk("depot","id", criteria.getDepot()==null?null:criteria.getDepot().getId());
        addPredicateFk("depot","id", criteria.getDepots());
    }

    public EntreeProduitSpecification(EntreeProduitCriteria criteria) {
        super(criteria);
    }

    public EntreeProduitSpecification(EntreeProduitCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
