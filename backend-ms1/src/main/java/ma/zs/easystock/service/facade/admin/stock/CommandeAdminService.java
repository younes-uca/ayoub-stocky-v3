package ma.zs.easystock.service.facade.admin.stock;

import java.util.List;
import ma.zs.easystock.bean.core.stock.Commande;
import ma.zs.easystock.dao.criteria.core.stock.CommandeCriteria;
import ma.zs.easystock.zynerator.service.IService;



public interface CommandeAdminService extends  IService<Commande,CommandeCriteria>  {

    List<Commande> findByClientId(Long id);
    int deleteByClientId(Long id);
    long countByClientTelephone(String telephone);
    List<Commande> findByEtatCommandeId(Long id);
    int deleteByEtatCommandeId(Long id);
    long countByEtatCommandeId(Long id);



}
