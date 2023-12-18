package  ma.zs.easystock.dao.specification.core.gestionchequeffet;

import ma.zs.easystock.dao.criteria.core.gestionchequeffet.TransactionFournisseurCriteria;
import ma.zs.easystock.bean.core.gestionchequeffet.TransactionFournisseur;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class TransactionFournisseurSpecification extends  AbstractSpecification<TransactionFournisseurCriteria, TransactionFournisseur>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("dateEmission", criteria.getDateEmission(), criteria.getDateEmissionFrom(), criteria.getDateEmissionTo());
        addPredicateBigDecimal("montant", criteria.getMontant(), criteria.getMontantMin(), criteria.getMontantMax());
        addPredicate("dateTransaction", criteria.getDateTransaction(), criteria.getDateTransactionFrom(), criteria.getDateTransactionTo());
        addPredicate("dateEncaissement", criteria.getDateEncaissement(), criteria.getDateEncaissementFrom(), criteria.getDateEncaissementTo());
        addPredicate("pathPhoto", criteria.getPathPhoto(),criteria.getPathPhotoLike());
        addPredicateFk("typeInstrument","id", criteria.getTypeInstrument()==null?null:criteria.getTypeInstrument().getId());
        addPredicateFk("typeInstrument","id", criteria.getTypeInstruments());
        addPredicateFk("typeTransaction","id", criteria.getTypeTransaction()==null?null:criteria.getTypeTransaction().getId());
        addPredicateFk("typeTransaction","id", criteria.getTypeTransactions());
        addPredicateFk("compte","id", criteria.getCompte()==null?null:criteria.getCompte().getId());
        addPredicateFk("compte","id", criteria.getComptes());
        addPredicateFk("etatTransaction","id", criteria.getEtatTransaction()==null?null:criteria.getEtatTransaction().getId());
        addPredicateFk("etatTransaction","id", criteria.getEtatTransactions());
    }

    public TransactionFournisseurSpecification(TransactionFournisseurCriteria criteria) {
        super(criteria);
    }

    public TransactionFournisseurSpecification(TransactionFournisseurCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
