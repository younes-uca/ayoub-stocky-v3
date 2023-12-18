package  ma.zs.easystock.dao.specification.core.stock;

import ma.zs.easystock.dao.criteria.core.stock.VenteCriteria;
import ma.zs.easystock.bean.core.stock.Vente;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class VenteSpecification extends  AbstractSpecification<VenteCriteria, Vente>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("barCode", criteria.getBarCode(),criteria.getBarCodeLike());
        addPredicate("codeVente", criteria.getCodeVente(),criteria.getCodeVenteLike());
        addPredicate("dateFacture", criteria.getDateFacture(), criteria.getDateFactureFrom(), criteria.getDateFactureTo());
        addPredicate("numeroFacture", criteria.getNumeroFacture(),criteria.getNumeroFactureLike());
        addPredicateBigDecimal("montantHt", criteria.getMontantHt(), criteria.getMontantHtMin(), criteria.getMontantHtMax());
        addPredicateBigDecimal("montantTva", criteria.getMontantTva(), criteria.getMontantTvaMin(), criteria.getMontantTvaMax());
        addPredicateBigDecimal("montantTtc", criteria.getMontantTtc(), criteria.getMontantTtcMin(), criteria.getMontantTtcMax());
        addPredicateFk("entrepriseSociete","id", criteria.getEntrepriseSociete()==null?null:criteria.getEntrepriseSociete().getId());
        addPredicateFk("entrepriseSociete","id", criteria.getEntrepriseSocietes());
        addPredicateFk("client","id", criteria.getClient()==null?null:criteria.getClient().getId());
        addPredicateFk("client","id", criteria.getClients());
        addPredicateFk("client","telephone", criteria.getClient()==null?null:criteria.getClient().getTelephone());
        addPredicateFk("etatVente","id", criteria.getEtatVente()==null?null:criteria.getEtatVente().getId());
        addPredicateFk("etatVente","id", criteria.getEtatVentes());
    }

    public VenteSpecification(VenteCriteria criteria) {
        super(criteria);
    }

    public VenteSpecification(VenteCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
