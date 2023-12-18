package ma.zs.easystock.service.impl.admin.stock;


import ma.zs.easystock.bean.core.stock.Tache;
import ma.zs.easystock.dao.criteria.core.stock.TacheCriteria;
import ma.zs.easystock.dao.facade.core.stock.TacheDao;
import ma.zs.easystock.dao.specification.core.stock.TacheSpecification;
import ma.zs.easystock.service.facade.admin.stock.TacheAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.easystock.service.facade.admin.commun.CollaborateurAdminService ;
import ma.zs.easystock.bean.core.commun.Collaborateur ;

import java.util.List;
@Service
public class TacheAdminServiceImpl extends AbstractServiceImpl<Tache, TacheCriteria, TacheDao> implements TacheAdminService {






    public List<Tache> findByCollaborateurId(Long id){
        return dao.findByCollaborateurId(id);
    }
    public int deleteByCollaborateurId(Long id){
        return dao.deleteByCollaborateurId(id);
    }
    public long countByCollaborateurTelephone(String telephone){
        return dao.countByCollaborateurTelephone(telephone);
    }






    public void configure() {
        super.configure(Tache.class, TacheSpecification.class);
    }


    @Autowired
    private CollaborateurAdminService collaborateurService ;

    public TacheAdminServiceImpl(TacheDao dao) {
        super(dao);
    }

}
