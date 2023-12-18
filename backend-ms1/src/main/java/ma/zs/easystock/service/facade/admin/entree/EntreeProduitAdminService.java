package ma.zs.easystock.service.facade.admin.entree;

import java.util.List;
import ma.zs.easystock.bean.core.entree.EntreeProduit;
import ma.zs.easystock.dao.criteria.core.entree.EntreeProduitCriteria;
import ma.zs.easystock.zynerator.service.IService;



public interface EntreeProduitAdminService extends  IService<EntreeProduit,EntreeProduitCriteria>  {

    List<EntreeProduit> findByFournisseurId(Long id);
    int deleteByFournisseurId(Long id);
    long countByFournisseurTelephone(String telephone);
    List<EntreeProduit> findByDepotId(Long id);
    int deleteByDepotId(Long id);
    long countByDepotId(Long id);



}
