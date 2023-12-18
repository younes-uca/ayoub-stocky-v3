package ma.zs.easystock.service.facade.admin.stock;

import java.util.List;
import ma.zs.easystock.bean.core.stock.Devis;
import ma.zs.easystock.dao.criteria.core.stock.DevisCriteria;
import ma.zs.easystock.zynerator.service.IService;



public interface DevisAdminService extends  IService<Devis,DevisCriteria>  {

    List<Devis> findByClientId(Long id);
    int deleteByClientId(Long id);
    long countByClientTelephone(String telephone);



}
