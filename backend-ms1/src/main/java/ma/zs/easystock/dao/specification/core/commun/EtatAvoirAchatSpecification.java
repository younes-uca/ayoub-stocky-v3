package  ma.zs.easystock.dao.specification.core.commun;

import ma.zs.easystock.dao.criteria.core.commun.EtatAvoirAchatCriteria;
import ma.zs.easystock.bean.core.commun.EtatAvoirAchat;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class EtatAvoirAchatSpecification extends  AbstractSpecification<EtatAvoirAchatCriteria, EtatAvoirAchat>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public EtatAvoirAchatSpecification(EtatAvoirAchatCriteria criteria) {
        super(criteria);
    }

    public EtatAvoirAchatSpecification(EtatAvoirAchatCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
