package ma.zs.easystock.service.facade.admin.gestionchequeffet;

import java.util.List;
import ma.zs.easystock.bean.core.gestionchequeffet.TransactionFournisseur;
import ma.zs.easystock.dao.criteria.core.gestionchequeffet.TransactionFournisseurCriteria;
import ma.zs.easystock.zynerator.service.IService;



public interface TransactionFournisseurAdminService extends  IService<TransactionFournisseur,TransactionFournisseurCriteria>  {

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
