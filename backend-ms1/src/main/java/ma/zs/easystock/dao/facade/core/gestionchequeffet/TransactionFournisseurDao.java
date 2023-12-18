package ma.zs.easystock.dao.facade.core.gestionchequeffet;

import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.bean.core.gestionchequeffet.TransactionFournisseur;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface TransactionFournisseurDao extends AbstractRepository<TransactionFournisseur,Long>  {

    List<TransactionFournisseur> findByTypeInstrumentId(Long id);
    int deleteByTypeInstrumentId(Long id);
    long countByTypeInstrumentId(Long id);
    List<TransactionFournisseur> findByTypeTransactionId(Long id);
    int deleteByTypeTransactionId(Long id);
    long countByTypeTransactionId(Long id);
    List<TransactionFournisseur> findByCompteId(Long id);
    int deleteByCompteId(Long id);
    long countByCompteId(Long id);
    List<TransactionFournisseur> findByEtatTransactionId(Long id);
    int deleteByEtatTransactionId(Long id);
    long countByEtatTransactionId(Long id);


}
