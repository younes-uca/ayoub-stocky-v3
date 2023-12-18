package ma.zs.easystock.service.facade.admin.stock;

import java.util.List;
import ma.zs.easystock.bean.core.stock.Vente;
import ma.zs.easystock.dao.criteria.core.stock.VenteCriteria;
import ma.zs.easystock.zynerator.service.IService;



public interface VenteAdminService extends  IService<Vente,VenteCriteria>  {

    List<Vente> findByEntrepriseSocieteId(Long id);
    int deleteByEntrepriseSocieteId(Long id);
    long countByEntrepriseSocieteId(Long id);
    List<Vente> findByClientId(Long id);
    int deleteByClientId(Long id);
    long countByClientTelephone(String telephone);
    List<Vente> findByEtatVenteId(Long id);
    int deleteByEtatVenteId(Long id);
    long countByEtatVenteId(Long id);



}
