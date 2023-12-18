package ma.zs.easystock.service.impl.admin.gestionchequeffet;


import ma.zs.easystock.bean.core.gestionchequeffet.TypeTransaction;
import ma.zs.easystock.dao.criteria.core.gestionchequeffet.TypeTransactionCriteria;
import ma.zs.easystock.dao.facade.core.gestionchequeffet.TypeTransactionDao;
import ma.zs.easystock.dao.specification.core.gestionchequeffet.TypeTransactionSpecification;
import ma.zs.easystock.service.facade.admin.gestionchequeffet.TypeTransactionAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class TypeTransactionAdminServiceImpl extends AbstractServiceImpl<TypeTransaction, TypeTransactionCriteria, TypeTransactionDao> implements TypeTransactionAdminService {







    public List<TypeTransaction> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(TypeTransaction.class, TypeTransactionSpecification.class);
    }



    public TypeTransactionAdminServiceImpl(TypeTransactionDao dao) {
        super(dao);
    }

}
