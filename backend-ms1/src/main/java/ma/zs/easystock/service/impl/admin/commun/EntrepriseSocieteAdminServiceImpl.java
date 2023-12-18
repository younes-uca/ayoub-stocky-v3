package ma.zs.easystock.service.impl.admin.commun;


import ma.zs.easystock.bean.core.commun.EntrepriseSociete;
import ma.zs.easystock.dao.criteria.core.commun.EntrepriseSocieteCriteria;
import ma.zs.easystock.dao.facade.core.commun.EntrepriseSocieteDao;
import ma.zs.easystock.dao.specification.core.commun.EntrepriseSocieteSpecification;
import ma.zs.easystock.service.facade.admin.commun.EntrepriseSocieteAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class EntrepriseSocieteAdminServiceImpl extends AbstractServiceImpl<EntrepriseSociete, EntrepriseSocieteCriteria, EntrepriseSocieteDao> implements EntrepriseSocieteAdminService {







    public List<EntrepriseSociete> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(EntrepriseSociete.class, EntrepriseSocieteSpecification.class);
    }



    public EntrepriseSocieteAdminServiceImpl(EntrepriseSocieteDao dao) {
        super(dao);
    }

}
