package  ma.zs.easystock.dao.specification.core.stock;

import ma.zs.easystock.dao.criteria.core.stock.VenteItemCriteria;
import ma.zs.easystock.bean.core.stock.VenteItem;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class VenteItemSpecification extends  AbstractSpecification<VenteItemCriteria, VenteItem>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("barCode", criteria.getBarCode(),criteria.getBarCodeLike());
        addPredicateBigDecimal("quantite", criteria.getQuantite(), criteria.getQuantiteMin(), criteria.getQuantiteMax());
        addPredicateBigDecimal("quantiteAvoir", criteria.getQuantiteAvoir(), criteria.getQuantiteAvoirMin(), criteria.getQuantiteAvoirMax());
        addPredicateBigDecimal("quantiteVendue", criteria.getQuantiteVendue(), criteria.getQuantiteVendueMin(), criteria.getQuantiteVendueMax());
        addPredicateBigDecimal("prixUnitaireHt", criteria.getPrixUnitaireHt(), criteria.getPrixUnitaireHtMin(), criteria.getPrixUnitaireHtMax());
        addPredicateBigDecimal("prixUnitaireTtc", criteria.getPrixUnitaireTtc(), criteria.getPrixUnitaireTtcMin(), criteria.getPrixUnitaireTtcMax());
        addPredicateBigDecimal("remise", criteria.getRemise(), criteria.getRemiseMin(), criteria.getRemiseMax());
        addPredicateBigDecimal("montantHt", criteria.getMontantHt(), criteria.getMontantHtMin(), criteria.getMontantHtMax());
        addPredicateBigDecimal("montantTtc", criteria.getMontantTtc(), criteria.getMontantTtcMin(), criteria.getMontantTtcMax());
        addPredicateFk("depot","id", criteria.getDepot()==null?null:criteria.getDepot().getId());
        addPredicateFk("depot","id", criteria.getDepots());
        addPredicateFk("produit","id", criteria.getProduit()==null?null:criteria.getProduit().getId());
        addPredicateFk("produit","id", criteria.getProduits());
        addPredicateFk("produit","reference", criteria.getProduit()==null?null:criteria.getProduit().getReference());
        addPredicateFk("taxe","id", criteria.getTaxe()==null?null:criteria.getTaxe().getId());
        addPredicateFk("taxe","id", criteria.getTaxes());
        addPredicateFk("vente","id", criteria.getVente()==null?null:criteria.getVente().getId());
        addPredicateFk("vente","id", criteria.getVentes());
        addPredicateFk("vente","numeroFacture", criteria.getVente()==null?null:criteria.getVente().getNumeroFacture());
    }

    public VenteItemSpecification(VenteItemCriteria criteria) {
        super(criteria);
    }

    public VenteItemSpecification(VenteItemCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
