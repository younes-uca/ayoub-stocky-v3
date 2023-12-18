package  ma.zs.easystock.dao.specification.core.stock;

import ma.zs.easystock.dao.criteria.core.stock.BonPourCriteria;
import ma.zs.easystock.bean.core.stock.BonPour;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class BonPourSpecification extends  AbstractSpecification<BonPourCriteria, BonPour>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("numero", criteria.getNumero(),criteria.getNumeroLike());
        addPredicate("dateBonPour", criteria.getDateBonPour(), criteria.getDateBonPourFrom(), criteria.getDateBonPourTo());
        addPredicateBigDecimal("montantHt", criteria.getMontantHt(), criteria.getMontantHtMin(), criteria.getMontantHtMax());
        addPredicateBigDecimal("montantTva", criteria.getMontantTva(), criteria.getMontantTvaMin(), criteria.getMontantTvaMax());
        addPredicateBigDecimal("montantTtc", criteria.getMontantTtc(), criteria.getMontantTtcMin(), criteria.getMontantTtcMax());
        addPredicateFk("client","id", criteria.getClient()==null?null:criteria.getClient().getId());
        addPredicateFk("client","id", criteria.getClients());
        addPredicateFk("client","telephone", criteria.getClient()==null?null:criteria.getClient().getTelephone());
    }

    public BonPourSpecification(BonPourCriteria criteria) {
        super(criteria);
    }

    public BonPourSpecification(BonPourCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
