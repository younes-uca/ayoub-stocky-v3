package ma.zs.easystock.service.facade.admin.gestionchequeffet;

import java.util.List;
import ma.zs.easystock.bean.core.gestionchequeffet.ChequeEffet;
import ma.zs.easystock.dao.criteria.core.gestionchequeffet.ChequeEffetCriteria;
import ma.zs.easystock.zynerator.service.IService;



public interface ChequeEffetAdminService extends  IService<ChequeEffet,ChequeEffetCriteria>  {

    List<ChequeEffet> findByFournisseurId(Long id);
    int deleteByFournisseurId(Long id);
    long countByFournisseurTelephone(String telephone);



}
