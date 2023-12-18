package  ma.zs.easystock.dao.specification.core.stock;

import ma.zs.easystock.dao.criteria.core.stock.ProduitCriteria;
import ma.zs.easystock.bean.core.stock.Produit;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class ProduitSpecification extends  AbstractSpecification<ProduitCriteria, Produit>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("reference", criteria.getReference(),criteria.getReferenceLike());
        addPredicate("barCode", criteria.getBarCode(),criteria.getBarCodeLike());
        addPredicate("designation", criteria.getDesignation(),criteria.getDesignationLike());
        addPredicateBigDecimal("quantite", criteria.getQuantite(), criteria.getQuantiteMin(), criteria.getQuantiteMax());
        addPredicateBigDecimal("prixAchatMoyen", criteria.getPrixAchatMoyen(), criteria.getPrixAchatMoyenMin(), criteria.getPrixAchatMoyenMax());
        addPredicateBigDecimal("prixVente", criteria.getPrixVente(), criteria.getPrixVenteMin(), criteria.getPrixVenteMax());
        addPredicate("pathPhoto", criteria.getPathPhoto(),criteria.getPathPhotoLike());
        addPredicateBigDecimal("seuilAlerte", criteria.getSeuilAlerte(), criteria.getSeuilAlerteMin(), criteria.getSeuilAlerteMax());
        addPredicateFk("entrepriseSociete","id", criteria.getEntrepriseSociete()==null?null:criteria.getEntrepriseSociete().getId());
        addPredicateFk("entrepriseSociete","id", criteria.getEntrepriseSocietes());
        addPredicateFk("categorie","id", criteria.getCategorie()==null?null:criteria.getCategorie().getId());
        addPredicateFk("categorie","id", criteria.getCategories());
        addPredicateFk("categorie","libelle", criteria.getCategorie()==null?null:criteria.getCategorie().getLibelle());
        addPredicateFk("marque","id", criteria.getMarque()==null?null:criteria.getMarque().getId());
        addPredicateFk("marque","id", criteria.getMarques());
        addPredicateFk("marque","libelle", criteria.getMarque()==null?null:criteria.getMarque().getLibelle());
        addPredicateFk("uniteMesure","id", criteria.getUniteMesure()==null?null:criteria.getUniteMesure().getId());
        addPredicateFk("uniteMesure","id", criteria.getUniteMesures());
        addPredicateFk("uniteMesure","libelle", criteria.getUniteMesure()==null?null:criteria.getUniteMesure().getLibelle());
    }

    public ProduitSpecification(ProduitCriteria criteria) {
        super(criteria);
    }

    public ProduitSpecification(ProduitCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
