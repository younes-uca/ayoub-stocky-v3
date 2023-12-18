package  ma.zs.easystock.dao.specification.core.reglement;

import ma.zs.easystock.dao.criteria.core.reglement.ReglementAchatCriteria;
import ma.zs.easystock.bean.core.reglement.ReglementAchat;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class ReglementAchatSpecification extends  AbstractSpecification<ReglementAchatCriteria, ReglementAchat>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("reference", criteria.getReference(),criteria.getReferenceLike());
        addPredicate("dateReglement", criteria.getDateReglement(), criteria.getDateReglementFrom(), criteria.getDateReglementTo());
        addPredicateBigDecimal("montant", criteria.getMontant(), criteria.getMontantMin(), criteria.getMontantMax());
        addPredicateFk("achat","id", criteria.getAchat()==null?null:criteria.getAchat().getId());
        addPredicateFk("achat","id", criteria.getAchats());
        addPredicateFk("modeReglement","id", criteria.getModeReglement()==null?null:criteria.getModeReglement().getId());
        addPredicateFk("modeReglement","id", criteria.getModeReglements());
    }

    public ReglementAchatSpecification(ReglementAchatCriteria criteria) {
        super(criteria);
    }

    public ReglementAchatSpecification(ReglementAchatCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
