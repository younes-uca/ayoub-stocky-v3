package  ma.zs.easystock.dao.specification.core.reglement;

import ma.zs.easystock.dao.criteria.core.reglement.ReglementVenteCriteria;
import ma.zs.easystock.bean.core.reglement.ReglementVente;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class ReglementVenteSpecification extends  AbstractSpecification<ReglementVenteCriteria, ReglementVente>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("reference", criteria.getReference(),criteria.getReferenceLike());
        addPredicate("dateReglement", criteria.getDateReglement(), criteria.getDateReglementFrom(), criteria.getDateReglementTo());
        addPredicateBigDecimal("montant", criteria.getMontant(), criteria.getMontantMin(), criteria.getMontantMax());
        addPredicateFk("vente","id", criteria.getVente()==null?null:criteria.getVente().getId());
        addPredicateFk("vente","id", criteria.getVentes());
        addPredicateFk("vente","numeroFacture", criteria.getVente()==null?null:criteria.getVente().getNumeroFacture());
        addPredicateFk("modeReglement","id", criteria.getModeReglement()==null?null:criteria.getModeReglement().getId());
        addPredicateFk("modeReglement","id", criteria.getModeReglements());
    }

    public ReglementVenteSpecification(ReglementVenteCriteria criteria) {
        super(criteria);
    }

    public ReglementVenteSpecification(ReglementVenteCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
