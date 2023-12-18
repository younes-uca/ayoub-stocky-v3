package  ma.zs.easystock.dao.specification.core.stock;

import ma.zs.easystock.dao.criteria.core.stock.SortieProduitItemCriteria;
import ma.zs.easystock.bean.core.stock.SortieProduitItem;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class SortieProduitItemSpecification extends  AbstractSpecification<SortieProduitItemCriteria, SortieProduitItem>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateBigDecimal("quantite", criteria.getQuantite(), criteria.getQuantiteMin(), criteria.getQuantiteMax());
        addPredicateFk("produit","id", criteria.getProduit()==null?null:criteria.getProduit().getId());
        addPredicateFk("produit","id", criteria.getProduits());
        addPredicateFk("produit","reference", criteria.getProduit()==null?null:criteria.getProduit().getReference());
        addPredicateFk("sortieProduit","id", criteria.getSortieProduit()==null?null:criteria.getSortieProduit().getId());
        addPredicateFk("sortieProduit","id", criteria.getSortieProduits());
        addPredicateFk("sortieProduit","reference", criteria.getSortieProduit()==null?null:criteria.getSortieProduit().getReference());
    }

    public SortieProduitItemSpecification(SortieProduitItemCriteria criteria) {
        super(criteria);
    }

    public SortieProduitItemSpecification(SortieProduitItemCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
