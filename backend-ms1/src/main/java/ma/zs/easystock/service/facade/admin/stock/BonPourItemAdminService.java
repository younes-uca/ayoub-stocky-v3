package ma.zs.easystock.service.facade.admin.stock;

import java.util.List;
import ma.zs.easystock.bean.core.stock.BonPourItem;
import ma.zs.easystock.dao.criteria.core.stock.BonPourItemCriteria;
import ma.zs.easystock.zynerator.service.IService;



public interface BonPourItemAdminService extends  IService<BonPourItem,BonPourItemCriteria>  {

    List<BonPourItem> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    long countByProduitReference(String reference);
    List<BonPourItem> findByTaxeId(Long id);
    int deleteByTaxeId(Long id);
    long countByTaxeId(Long id);
    List<BonPourItem> findByBonPourId(Long id);
    int deleteByBonPourId(Long id);
    long countByBonPourNumero(String numero);



}
