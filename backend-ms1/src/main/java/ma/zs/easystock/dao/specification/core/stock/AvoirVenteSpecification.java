package  ma.zs.easystock.dao.specification.core.stock;

import ma.zs.easystock.dao.criteria.core.stock.AvoirVenteCriteria;
import ma.zs.easystock.bean.core.stock.AvoirVente;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class AvoirVenteSpecification extends  AbstractSpecification<AvoirVenteCriteria, AvoirVente>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("barCode", criteria.getBarCode(),criteria.getBarCodeLike());
        addPredicate("codeAvoirVente", criteria.getCodeAvoirVente(),criteria.getCodeAvoirVenteLike());
        addPredicate("numeroFactureAvoirVente", criteria.getNumeroFactureAvoirVente(),criteria.getNumeroFactureAvoirVenteLike());
        addPredicate("dateFactureAvoirVente", criteria.getDateFactureAvoirVente(), criteria.getDateFactureAvoirVenteFrom(), criteria.getDateFactureAvoirVenteTo());
        addPredicateBigDecimal("montantHt", criteria.getMontantHt(), criteria.getMontantHtMin(), criteria.getMontantHtMax());
        addPredicateBigDecimal("montantTva", criteria.getMontantTva(), criteria.getMontantTvaMin(), criteria.getMontantTvaMax());
        addPredicateBigDecimal("montantTtc", criteria.getMontantTtc(), criteria.getMontantTtcMin(), criteria.getMontantTtcMax());
        addPredicateFk("entrepriseSociete","id", criteria.getEntrepriseSociete()==null?null:criteria.getEntrepriseSociete().getId());
        addPredicateFk("entrepriseSociete","id", criteria.getEntrepriseSocietes());
        addPredicateFk("client","id", criteria.getClient()==null?null:criteria.getClient().getId());
        addPredicateFk("client","id", criteria.getClients());
        addPredicateFk("client","telephone", criteria.getClient()==null?null:criteria.getClient().getTelephone());
        addPredicateFk("etatAvoirVente","id", criteria.getEtatAvoirVente()==null?null:criteria.getEtatAvoirVente().getId());
        addPredicateFk("etatAvoirVente","id", criteria.getEtatAvoirVentes());
        addPredicateFk("vente","id", criteria.getVente()==null?null:criteria.getVente().getId());
        addPredicateFk("vente","id", criteria.getVentes());
        addPredicateFk("vente","numeroFacture", criteria.getVente()==null?null:criteria.getVente().getNumeroFacture());
    }

    public AvoirVenteSpecification(AvoirVenteCriteria criteria) {
        super(criteria);
    }

    public AvoirVenteSpecification(AvoirVenteCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
