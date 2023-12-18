package ma.zs.easystock.service.impl.admin.gestionchequeffet;


import ma.zs.easystock.bean.core.gestionchequeffet.ModeReglement;
import ma.zs.easystock.dao.criteria.core.gestionchequeffet.ModeReglementCriteria;
import ma.zs.easystock.dao.facade.core.gestionchequeffet.ModeReglementDao;
import ma.zs.easystock.dao.specification.core.gestionchequeffet.ModeReglementSpecification;
import ma.zs.easystock.service.facade.admin.gestionchequeffet.ModeReglementAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class ModeReglementAdminServiceImpl extends AbstractServiceImpl<ModeReglement, ModeReglementCriteria, ModeReglementDao> implements ModeReglementAdminService {







    public List<ModeReglement> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(ModeReglement.class, ModeReglementSpecification.class);
    }



    public ModeReglementAdminServiceImpl(ModeReglementDao dao) {
        super(dao);
    }

}
