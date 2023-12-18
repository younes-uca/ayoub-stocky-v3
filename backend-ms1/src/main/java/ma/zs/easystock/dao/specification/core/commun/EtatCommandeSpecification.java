package  ma.zs.easystock.dao.specification.core.commun;

import ma.zs.easystock.dao.criteria.core.commun.EtatCommandeCriteria;
import ma.zs.easystock.bean.core.commun.EtatCommande;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class EtatCommandeSpecification extends  AbstractSpecification<EtatCommandeCriteria, EtatCommande>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public EtatCommandeSpecification(EtatCommandeCriteria criteria) {
        super(criteria);
    }

    public EtatCommandeSpecification(EtatCommandeCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
