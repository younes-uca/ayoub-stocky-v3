package  ma.zs.easystock.dao.specification.core.stock;

import ma.zs.easystock.dao.criteria.core.stock.StockCriteria;
import ma.zs.easystock.bean.core.stock.Stock;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class StockSpecification extends  AbstractSpecification<StockCriteria, Stock>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateBigDecimal("quantite", criteria.getQuantite(), criteria.getQuantiteMin(), criteria.getQuantiteMax());
        addPredicateFk("produit","id", criteria.getProduit()==null?null:criteria.getProduit().getId());
        addPredicateFk("produit","id", criteria.getProduits());
        addPredicateFk("produit","reference", criteria.getProduit()==null?null:criteria.getProduit().getReference());
        addPredicateFk("depot","id", criteria.getDepot()==null?null:criteria.getDepot().getId());
        addPredicateFk("depot","id", criteria.getDepots());
    }

    public StockSpecification(StockCriteria criteria) {
        super(criteria);
    }

    public StockSpecification(StockCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
