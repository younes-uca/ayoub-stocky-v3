package ma.zs.easystock.service.facade.admin.entree;

import java.util.List;
import ma.zs.easystock.bean.core.entree.SortieProduit;
import ma.zs.easystock.dao.criteria.core.entree.SortieProduitCriteria;
import ma.zs.easystock.zynerator.service.IService;



public interface SortieProduitAdminService extends  IService<SortieProduit,SortieProduitCriteria>  {

    List<SortieProduit> findByDepotId(Long id);
    int deleteByDepotId(Long id);
    long countByDepotId(Long id);



}
