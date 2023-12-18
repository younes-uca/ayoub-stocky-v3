package  ma.zs.easystock.dao.specification.core.reglement;

import ma.zs.easystock.dao.criteria.core.reglement.ReglementAvoirAchatCriteria;
import ma.zs.easystock.bean.core.reglement.ReglementAvoirAchat;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class ReglementAvoirAchatSpecification extends  AbstractSpecification<ReglementAvoirAchatCriteria, ReglementAvoirAchat>  {

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
        addPredicateFk("avoirAchat","id", criteria.getAvoirAchat()==null?null:criteria.getAvoirAchat().getId());
        addPredicateFk("avoirAchat","id", criteria.getAvoirAchats());
        addPredicateFk("avoirAchat","numeroFactureAvoirFournisseur", criteria.getAvoirAchat()==null?null:criteria.getAvoirAchat().getNumeroFactureAvoirFournisseur());
    }

    public ReglementAvoirAchatSpecification(ReglementAvoirAchatCriteria criteria) {
        super(criteria);
    }

    public ReglementAvoirAchatSpecification(ReglementAvoirAchatCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
