package ma.zs.easystock.service.facade.admin.stock;

import java.util.List;
import ma.zs.easystock.bean.core.stock.AvoirAchat;
import ma.zs.easystock.dao.criteria.core.stock.AvoirAchatCriteria;
import ma.zs.easystock.zynerator.service.IService;



public interface AvoirAchatAdminService extends  IService<AvoirAchat,AvoirAchatCriteria>  {

    List<AvoirAchat> findByEntrepriseSocieteId(Long id);
    int deleteByEntrepriseSocieteId(Long id);
    long countByEntrepriseSocieteId(Long id);
    List<AvoirAchat> findByFournisseurId(Long id);
    int deleteByFournisseurId(Long id);
    long countByFournisseurTelephone(String telephone);
    List<AvoirAchat> findByEtatAvoirAchatId(Long id);
    int deleteByEtatAvoirAchatId(Long id);
    long countByEtatAvoirAchatId(Long id);
    List<AvoirAchat> findByAchatId(Long id);
    int deleteByAchatId(Long id);
    long countByAchatId(Long id);



}
