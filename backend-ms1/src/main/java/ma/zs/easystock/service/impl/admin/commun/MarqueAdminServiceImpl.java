package ma.zs.easystock.service.impl.admin.commun;


import ma.zs.easystock.bean.core.commun.Marque;
import ma.zs.easystock.dao.criteria.core.commun.MarqueCriteria;
import ma.zs.easystock.dao.facade.core.commun.MarqueDao;
import ma.zs.easystock.dao.specification.core.commun.MarqueSpecification;
import ma.zs.easystock.service.facade.admin.commun.MarqueAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class MarqueAdminServiceImpl extends AbstractServiceImpl<Marque, MarqueCriteria, MarqueDao> implements MarqueAdminService {





    public Marque findByReferenceEntity(Marque t){
        return  dao.findByLibelle(t.getLibelle());
    }


    public List<Marque> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(Marque.class, MarqueSpecification.class);
    }



    public MarqueAdminServiceImpl(MarqueDao dao) {
        super(dao);
    }

}
