package  ma.zs.easystock.dao.specification.core.commun;

import ma.zs.easystock.dao.criteria.core.commun.CategorieCriteria;
import ma.zs.easystock.bean.core.commun.Categorie;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class CategorieSpecification extends  AbstractSpecification<CategorieCriteria, Categorie>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public CategorieSpecification(CategorieCriteria criteria) {
        super(criteria);
    }

    public CategorieSpecification(CategorieCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
