package  ma.zs.easystock.dao.specification.core.commun;

import ma.zs.easystock.dao.criteria.core.commun.EtatAchatCriteria;
import ma.zs.easystock.bean.core.commun.EtatAchat;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class EtatAchatSpecification extends  AbstractSpecification<EtatAchatCriteria, EtatAchat>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public EtatAchatSpecification(EtatAchatCriteria criteria) {
        super(criteria);
    }

    public EtatAchatSpecification(EtatAchatCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
