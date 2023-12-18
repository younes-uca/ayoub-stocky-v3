package ma.zs.easystock.service.impl.admin.gestionchequeffet;


import ma.zs.easystock.bean.core.gestionchequeffet.EtatTransaction;
import ma.zs.easystock.dao.criteria.core.gestionchequeffet.EtatTransactionCriteria;
import ma.zs.easystock.dao.facade.core.gestionchequeffet.EtatTransactionDao;
import ma.zs.easystock.dao.specification.core.gestionchequeffet.EtatTransactionSpecification;
import ma.zs.easystock.service.facade.admin.gestionchequeffet.EtatTransactionAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class EtatTransactionAdminServiceImpl extends AbstractServiceImpl<EtatTransaction, EtatTransactionCriteria, EtatTransactionDao> implements EtatTransactionAdminService {







    public List<EtatTransaction> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(EtatTransaction.class, EtatTransactionSpecification.class);
    }



    public EtatTransactionAdminServiceImpl(EtatTransactionDao dao) {
        super(dao);
    }

}
