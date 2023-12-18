package  ma.zs.easystock.dao.specification.core.commun;

import ma.zs.easystock.dao.criteria.core.commun.EtatVenteCriteria;
import ma.zs.easystock.bean.core.commun.EtatVente;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class EtatVenteSpecification extends  AbstractSpecification<EtatVenteCriteria, EtatVente>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public EtatVenteSpecification(EtatVenteCriteria criteria) {
        super(criteria);
    }

    public EtatVenteSpecification(EtatVenteCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
