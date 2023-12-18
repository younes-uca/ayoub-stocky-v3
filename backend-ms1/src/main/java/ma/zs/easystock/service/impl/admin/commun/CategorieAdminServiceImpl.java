package ma.zs.easystock.service.impl.admin.commun;


import ma.zs.easystock.bean.core.commun.Categorie;
import ma.zs.easystock.dao.criteria.core.commun.CategorieCriteria;
import ma.zs.easystock.dao.facade.core.commun.CategorieDao;
import ma.zs.easystock.dao.specification.core.commun.CategorieSpecification;
import ma.zs.easystock.service.facade.admin.commun.CategorieAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class CategorieAdminServiceImpl extends AbstractServiceImpl<Categorie, CategorieCriteria, CategorieDao> implements CategorieAdminService {





    public Categorie findByReferenceEntity(Categorie t){
        return  dao.findByLibelle(t.getLibelle());
    }


    public List<Categorie> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(Categorie.class, CategorieSpecification.class);
    }



    public CategorieAdminServiceImpl(CategorieDao dao) {
        super(dao);
    }

}
