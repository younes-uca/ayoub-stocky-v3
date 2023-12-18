package  ma.zs.easystock.dao.specification.core.stock;

import ma.zs.easystock.dao.criteria.core.stock.AchatCriteria;
import ma.zs.easystock.bean.core.stock.Achat;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class AchatSpecification extends  AbstractSpecification<AchatCriteria, Achat>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("dateFacture", criteria.getDateFacture(), criteria.getDateFactureFrom(), criteria.getDateFactureTo());
        addPredicate("referenceFacture", criteria.getReferenceFacture(),criteria.getReferenceFactureLike());
        addPredicateBigDecimal("montantHt", criteria.getMontantHt(), criteria.getMontantHtMin(), criteria.getMontantHtMax());
        addPredicateBigDecimal("montantTva", criteria.getMontantTva(), criteria.getMontantTvaMin(), criteria.getMontantTvaMax());
        addPredicateBigDecimal("montantTtc", criteria.getMontantTtc(), criteria.getMontantTtcMin(), criteria.getMontantTtcMax());
        addPredicateFk("entrepriseSociete","id", criteria.getEntrepriseSociete()==null?null:criteria.getEntrepriseSociete().getId());
        addPredicateFk("entrepriseSociete","id", criteria.getEntrepriseSocietes());
        addPredicateFk("fournisseur","id", criteria.getFournisseur()==null?null:criteria.getFournisseur().getId());
        addPredicateFk("fournisseur","id", criteria.getFournisseurs());
        addPredicateFk("fournisseur","telephone", criteria.getFournisseur()==null?null:criteria.getFournisseur().getTelephone());
        addPredicateFk("etatAchat","id", criteria.getEtatAchat()==null?null:criteria.getEtatAchat().getId());
        addPredicateFk("etatAchat","id", criteria.getEtatAchats());
    }

    public AchatSpecification(AchatCriteria criteria) {
        super(criteria);
    }

    public AchatSpecification(AchatCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
