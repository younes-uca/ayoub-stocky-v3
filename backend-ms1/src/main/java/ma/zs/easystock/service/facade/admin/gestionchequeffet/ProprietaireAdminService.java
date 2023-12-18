package ma.zs.easystock.service.facade.admin.gestionchequeffet;

import java.util.List;
import ma.zs.easystock.bean.core.gestionchequeffet.Proprietaire;
import ma.zs.easystock.dao.criteria.core.gestionchequeffet.ProprietaireCriteria;
import ma.zs.easystock.zynerator.service.IService;



public interface ProprietaireAdminService extends  IService<Proprietaire,ProprietaireCriteria>  {
    Proprietaire findByUsername(String username);
    boolean changePassword(String username, String newPassword);




}
