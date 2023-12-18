package  ma.zs.easystock.dao.specification.core.commun;

import ma.zs.easystock.dao.criteria.core.commun.EtatAvoirVenteCriteria;
import ma.zs.easystock.bean.core.commun.EtatAvoirVente;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class EtatAvoirVenteSpecification extends  AbstractSpecification<EtatAvoirVenteCriteria, EtatAvoirVente>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public EtatAvoirVenteSpecification(EtatAvoirVenteCriteria criteria) {
        super(criteria);
    }

    public EtatAvoirVenteSpecification(EtatAvoirVenteCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
