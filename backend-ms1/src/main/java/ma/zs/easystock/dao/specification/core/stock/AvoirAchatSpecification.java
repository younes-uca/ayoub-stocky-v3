package  ma.zs.easystock.dao.specification.core.stock;

import ma.zs.easystock.dao.criteria.core.stock.AvoirAchatCriteria;
import ma.zs.easystock.bean.core.stock.AvoirAchat;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class AvoirAchatSpecification extends  AbstractSpecification<AvoirAchatCriteria, AvoirAchat>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("barCode", criteria.getBarCode(),criteria.getBarCodeLike());
        addPredicate("codeAvoirAchat", criteria.getCodeAvoirAchat(),criteria.getCodeAvoirAchatLike());
        addPredicate("numeroFactureAvoirFournisseur", criteria.getNumeroFactureAvoirFournisseur(),criteria.getNumeroFactureAvoirFournisseurLike());
        addPredicate("dateFactureAvoirFournisseur", criteria.getDateFactureAvoirFournisseur(), criteria.getDateFactureAvoirFournisseurFrom(), criteria.getDateFactureAvoirFournisseurTo());
        addPredicateBigDecimal("montantHt", criteria.getMontantHt(), criteria.getMontantHtMin(), criteria.getMontantHtMax());
        addPredicateBigDecimal("montantTva", criteria.getMontantTva(), criteria.getMontantTvaMin(), criteria.getMontantTvaMax());
        addPredicateBigDecimal("montantTtc", criteria.getMontantTtc(), criteria.getMontantTtcMin(), criteria.getMontantTtcMax());
        addPredicateFk("entrepriseSociete","id", criteria.getEntrepriseSociete()==null?null:criteria.getEntrepriseSociete().getId());
        addPredicateFk("entrepriseSociete","id", criteria.getEntrepriseSocietes());
        addPredicateFk("fournisseur","id", criteria.getFournisseur()==null?null:criteria.getFournisseur().getId());
        addPredicateFk("fournisseur","id", criteria.getFournisseurs());
        addPredicateFk("fournisseur","telephone", criteria.getFournisseur()==null?null:criteria.getFournisseur().getTelephone());
        addPredicateFk("etatAvoirAchat","id", criteria.getEtatAvoirAchat()==null?null:criteria.getEtatAvoirAchat().getId());
        addPredicateFk("etatAvoirAchat","id", criteria.getEtatAvoirAchats());
        addPredicateFk("achat","id", criteria.getAchat()==null?null:criteria.getAchat().getId());
        addPredicateFk("achat","id", criteria.getAchats());
    }

    public AvoirAchatSpecification(AvoirAchatCriteria criteria) {
        super(criteria);
    }

    public AvoirAchatSpecification(AvoirAchatCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
