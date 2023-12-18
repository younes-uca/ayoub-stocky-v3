package ma.zs.easystock.service.facade.admin.stock;

import java.util.List;
import ma.zs.easystock.bean.core.stock.CommandeItem;
import ma.zs.easystock.dao.criteria.core.stock.CommandeItemCriteria;
import ma.zs.easystock.zynerator.service.IService;



public interface CommandeItemAdminService extends  IService<CommandeItem,CommandeItemCriteria>  {

    List<CommandeItem> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    long countByProduitReference(String reference);
    List<CommandeItem> findByTaxeId(Long id);
    int deleteByTaxeId(Long id);
    long countByTaxeId(Long id);
    List<CommandeItem> findByCommandeId(Long id);
    int deleteByCommandeId(Long id);
    long countByCommandeNumeroCommande(String numeroCommande);



}
