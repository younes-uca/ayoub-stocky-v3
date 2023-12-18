package ma.zs.easystock.service.impl.admin.Transfert;


import ma.zs.easystock.bean.core.Transfert.Raison;
import ma.zs.easystock.dao.criteria.core.Transfert.RaisonCriteria;
import ma.zs.easystock.dao.facade.core.Transfert.RaisonDao;
import ma.zs.easystock.dao.specification.core.Transfert.RaisonSpecification;
import ma.zs.easystock.service.facade.admin.Transfert.RaisonAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class RaisonAdminServiceImpl extends AbstractServiceImpl<Raison, RaisonCriteria, RaisonDao> implements RaisonAdminService {







    public List<Raison> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(Raison.class, RaisonSpecification.class);
    }



    public RaisonAdminServiceImpl(RaisonDao dao) {
        super(dao);
    }

}
