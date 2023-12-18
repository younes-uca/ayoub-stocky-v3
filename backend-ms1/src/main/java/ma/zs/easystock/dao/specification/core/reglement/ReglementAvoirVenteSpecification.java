package  ma.zs.easystock.dao.specification.core.reglement;

import ma.zs.easystock.dao.criteria.core.reglement.ReglementAvoirVenteCriteria;
import ma.zs.easystock.bean.core.reglement.ReglementAvoirVente;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class ReglementAvoirVenteSpecification extends  AbstractSpecification<ReglementAvoirVenteCriteria, ReglementAvoirVente>  {

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
        addPredicateFk("avoirVente","id", criteria.getAvoirVente()==null?null:criteria.getAvoirVente().getId());
        addPredicateFk("avoirVente","id", criteria.getAvoirVentes());
        addPredicateFk("avoirVente","numeroFactureAvoirVente", criteria.getAvoirVente()==null?null:criteria.getAvoirVente().getNumeroFactureAvoirVente());
    }

    public ReglementAvoirVenteSpecification(ReglementAvoirVenteCriteria criteria) {
        super(criteria);
    }

    public ReglementAvoirVenteSpecification(ReglementAvoirVenteCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
