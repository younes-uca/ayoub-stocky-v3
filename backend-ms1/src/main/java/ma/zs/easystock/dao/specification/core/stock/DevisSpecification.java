package  ma.zs.easystock.dao.specification.core.stock;

import ma.zs.easystock.dao.criteria.core.stock.DevisCriteria;
import ma.zs.easystock.bean.core.stock.Devis;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class DevisSpecification extends  AbstractSpecification<DevisCriteria, Devis>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("numero", criteria.getNumero(),criteria.getNumeroLike());
        addPredicate("dateDevis", criteria.getDateDevis(), criteria.getDateDevisFrom(), criteria.getDateDevisTo());
        addPredicateBigDecimal("montantHt", criteria.getMontantHt(), criteria.getMontantHtMin(), criteria.getMontantHtMax());
        addPredicateBigDecimal("montantTva", criteria.getMontantTva(), criteria.getMontantTvaMin(), criteria.getMontantTvaMax());
        addPredicateBigDecimal("montantTtc", criteria.getMontantTtc(), criteria.getMontantTtcMin(), criteria.getMontantTtcMax());
        addPredicateFk("client","id", criteria.getClient()==null?null:criteria.getClient().getId());
        addPredicateFk("client","id", criteria.getClients());
        addPredicateFk("client","telephone", criteria.getClient()==null?null:criteria.getClient().getTelephone());
    }

    public DevisSpecification(DevisCriteria criteria) {
        super(criteria);
    }

    public DevisSpecification(DevisCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
