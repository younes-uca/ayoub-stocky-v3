package  ma.zs.easystock.dao.specification.core.gestionchequeffet;

import ma.zs.easystock.dao.criteria.core.gestionchequeffet.ChequeEffetCriteria;
import ma.zs.easystock.bean.core.gestionchequeffet.ChequeEffet;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class ChequeEffetSpecification extends  AbstractSpecification<ChequeEffetCriteria, ChequeEffet>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("numero", criteria.getNumero(),criteria.getNumeroLike());
        addPredicate("dateEmission", criteria.getDateEmission(), criteria.getDateEmissionFrom(), criteria.getDateEmissionTo());
        addPredicateBigDecimal("montant", criteria.getMontant(), criteria.getMontantMin(), criteria.getMontantMax());
        addPredicateFk("fournisseur","id", criteria.getFournisseur()==null?null:criteria.getFournisseur().getId());
        addPredicateFk("fournisseur","id", criteria.getFournisseurs());
        addPredicateFk("fournisseur","telephone", criteria.getFournisseur()==null?null:criteria.getFournisseur().getTelephone());
    }

    public ChequeEffetSpecification(ChequeEffetCriteria criteria) {
        super(criteria);
    }

    public ChequeEffetSpecification(ChequeEffetCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
