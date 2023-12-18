package  ma.zs.easystock.dao.specification.core.stock;

import ma.zs.easystock.dao.criteria.core.stock.InventaireItemCriteria;
import ma.zs.easystock.bean.core.stock.InventaireItem;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class InventaireItemSpecification extends  AbstractSpecification<InventaireItemCriteria, InventaireItem>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateBigDecimal("quantiteEstime", criteria.getQuantiteEstime(), criteria.getQuantiteEstimeMin(), criteria.getQuantiteEstimeMax());
        addPredicateBigDecimal("quantiteReelle", criteria.getQuantiteReelle(), criteria.getQuantiteReelleMin(), criteria.getQuantiteReelleMax());
        addPredicateFk("produit","id", criteria.getProduit()==null?null:criteria.getProduit().getId());
        addPredicateFk("produit","id", criteria.getProduits());
        addPredicateFk("produit","reference", criteria.getProduit()==null?null:criteria.getProduit().getReference());
        addPredicateFk("inventaire","id", criteria.getInventaire()==null?null:criteria.getInventaire().getId());
        addPredicateFk("inventaire","id", criteria.getInventaires());
        addPredicateFk("inventaire","reference", criteria.getInventaire()==null?null:criteria.getInventaire().getReference());
    }

    public InventaireItemSpecification(InventaireItemCriteria criteria) {
        super(criteria);
    }

    public InventaireItemSpecification(InventaireItemCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
