package ma.zs.easystock.service.impl.admin.gestionchequeffet;


import ma.zs.easystock.bean.core.gestionchequeffet.TypeInstrument;
import ma.zs.easystock.dao.criteria.core.gestionchequeffet.TypeInstrumentCriteria;
import ma.zs.easystock.dao.facade.core.gestionchequeffet.TypeInstrumentDao;
import ma.zs.easystock.dao.specification.core.gestionchequeffet.TypeInstrumentSpecification;
import ma.zs.easystock.service.facade.admin.gestionchequeffet.TypeInstrumentAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class TypeInstrumentAdminServiceImpl extends AbstractServiceImpl<TypeInstrument, TypeInstrumentCriteria, TypeInstrumentDao> implements TypeInstrumentAdminService {







    public List<TypeInstrument> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(TypeInstrument.class, TypeInstrumentSpecification.class);
    }



    public TypeInstrumentAdminServiceImpl(TypeInstrumentDao dao) {
        super(dao);
    }

}
