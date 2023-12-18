package  ma.zs.easystock.dao.specification.core.stock;

import ma.zs.easystock.dao.criteria.core.stock.DevisItemCriteria;
import ma.zs.easystock.bean.core.stock.DevisItem;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class DevisItemSpecification extends  AbstractSpecification<DevisItemCriteria, DevisItem>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateBigDecimal("quantite", criteria.getQuantite(), criteria.getQuantiteMin(), criteria.getQuantiteMax());
        addPredicateBigDecimal("prixUnitaireHt", criteria.getPrixUnitaireHt(), criteria.getPrixUnitaireHtMin(), criteria.getPrixUnitaireHtMax());
        addPredicateBigDecimal("prixUnitaireTtc", criteria.getPrixUnitaireTtc(), criteria.getPrixUnitaireTtcMin(), criteria.getPrixUnitaireTtcMax());
        addPredicateBigDecimal("remise", criteria.getRemise(), criteria.getRemiseMin(), criteria.getRemiseMax());
        addPredicateBigDecimal("montantHt", criteria.getMontantHt(), criteria.getMontantHtMin(), criteria.getMontantHtMax());
        addPredicateBigDecimal("montantTtc", criteria.getMontantTtc(), criteria.getMontantTtcMin(), criteria.getMontantTtcMax());
        addPredicateFk("produit","id", criteria.getProduit()==null?null:criteria.getProduit().getId());
        addPredicateFk("produit","id", criteria.getProduits());
        addPredicateFk("produit","reference", criteria.getProduit()==null?null:criteria.getProduit().getReference());
        addPredicateFk("taxe","id", criteria.getTaxe()==null?null:criteria.getTaxe().getId());
        addPredicateFk("taxe","id", criteria.getTaxes());
        addPredicateFk("devis","id", criteria.getDevis()==null?null:criteria.getDevis().getId());
        addPredicateFk("devis","id", criteria.getDeviss());
        addPredicateFk("devis","numero", criteria.getDevis()==null?null:criteria.getDevis().getNumero());
    }

    public DevisItemSpecification(DevisItemCriteria criteria) {
        super(criteria);
    }

    public DevisItemSpecification(DevisItemCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
