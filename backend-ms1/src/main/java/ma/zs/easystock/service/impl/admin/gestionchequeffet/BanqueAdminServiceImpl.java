package ma.zs.easystock.service.impl.admin.gestionchequeffet;


import ma.zs.easystock.bean.core.gestionchequeffet.Banque;
import ma.zs.easystock.dao.criteria.core.gestionchequeffet.BanqueCriteria;
import ma.zs.easystock.dao.facade.core.gestionchequeffet.BanqueDao;
import ma.zs.easystock.dao.specification.core.gestionchequeffet.BanqueSpecification;
import ma.zs.easystock.service.facade.admin.gestionchequeffet.BanqueAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class BanqueAdminServiceImpl extends AbstractServiceImpl<Banque, BanqueCriteria, BanqueDao> implements BanqueAdminService {







    public List<Banque> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(Banque.class, BanqueSpecification.class);
    }



    public BanqueAdminServiceImpl(BanqueDao dao) {
        super(dao);
    }

}
