package ma.zs.easystock.service.facade.admin.stock;

import java.util.List;
import ma.zs.easystock.bean.core.stock.Tache;
import ma.zs.easystock.dao.criteria.core.stock.TacheCriteria;
import ma.zs.easystock.zynerator.service.IService;



public interface TacheAdminService extends  IService<Tache,TacheCriteria>  {

    List<Tache> findByCollaborateurId(Long id);
    int deleteByCollaborateurId(Long id);
    long countByCollaborateurTelephone(String telephone);



}
