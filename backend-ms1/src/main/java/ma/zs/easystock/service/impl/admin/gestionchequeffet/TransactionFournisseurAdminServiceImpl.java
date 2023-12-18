package ma.zs.easystock.service.impl.admin.gestionchequeffet;


import ma.zs.easystock.bean.core.gestionchequeffet.TransactionFournisseur;
import ma.zs.easystock.dao.criteria.core.gestionchequeffet.TransactionFournisseurCriteria;
import ma.zs.easystock.dao.facade.core.gestionchequeffet.TransactionFournisseurDao;
import ma.zs.easystock.dao.specification.core.gestionchequeffet.TransactionFournisseurSpecification;
import ma.zs.easystock.service.facade.admin.gestionchequeffet.TransactionFournisseurAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.easystock.service.facade.admin.gestionchequeffet.EtatTransactionAdminService ;
import ma.zs.easystock.bean.core.gestionchequeffet.EtatTransaction ;
import ma.zs.easystock.service.facade.admin.gestionchequeffet.TypeTransactionAdminService ;
import ma.zs.easystock.bean.core.gestionchequeffet.TypeTransaction ;
import ma.zs.easystock.service.facade.admin.gestionchequeffet.CompteAdminService ;
import ma.zs.easystock.bean.core.gestionchequeffet.Compte ;
import ma.zs.easystock.service.facade.admin.gestionchequeffet.TypeInstrumentAdminService ;
import ma.zs.easystock.bean.core.gestionchequeffet.TypeInstrument ;

import java.util.List;
@Service
public class TransactionFournisseurAdminServiceImpl extends AbstractServiceImpl<TransactionFournisseur, TransactionFournisseurCriteria, TransactionFournisseurDao> implements TransactionFournisseurAdminService {






    public List<TransactionFournisseur> findByTypeInstrumentId(Long id){
        return dao.findByTypeInstrumentId(id);
    }
    public int deleteByTypeInstrumentId(Long id){
        return dao.deleteByTypeInstrumentId(id);
    }
    public long countByTypeInstrumentId(Long id){
        return dao.countByTypeInstrumentId(id);
    }
    public List<TransactionFournisseur> findByTypeTransactionId(Long id){
        return dao.findByTypeTransactionId(id);
    }
    public int deleteByTypeTransactionId(Long id){
        return dao.deleteByTypeTransactionId(id);
    }
    public long countByTypeTransactionId(Long id){
        return dao.countByTypeTransactionId(id);
    }
    public List<TransactionFournisseur> findByCompteId(Long id){
        return dao.findByCompteId(id);
    }
    public int deleteByCompteId(Long id){
        return dao.deleteByCompteId(id);
    }
    public long countByCompteId(Long id){
        return dao.countByCompteId(id);
    }
    public List<TransactionFournisseur> findByEtatTransactionId(Long id){
        return dao.findByEtatTransactionId(id);
    }
    public int deleteByEtatTransactionId(Long id){
        return dao.deleteByEtatTransactionId(id);
    }
    public long countByEtatTransactionId(Long id){
        return dao.countByEtatTransactionId(id);
    }






    public void configure() {
        super.configure(TransactionFournisseur.class, TransactionFournisseurSpecification.class);
    }


    @Autowired
    private EtatTransactionAdminService etatTransactionService ;
    @Autowired
    private TypeTransactionAdminService typeTransactionService ;
    @Autowired
    private CompteAdminService compteService ;
    @Autowired
    private TypeInstrumentAdminService typeInstrumentService ;

    public TransactionFournisseurAdminServiceImpl(TransactionFournisseurDao dao) {
        super(dao);
    }

}
