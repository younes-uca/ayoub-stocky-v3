package ma.zs.easystock.service.facade.admin.commun;

import java.util.List;
import ma.zs.easystock.bean.core.commun.Collaborateur;
import ma.zs.easystock.dao.criteria.core.commun.CollaborateurCriteria;
import ma.zs.easystock.zynerator.service.IService;



public interface CollaborateurAdminService extends  IService<Collaborateur,CollaborateurCriteria>  {
    Collaborateur findByUsername(String username);
    boolean changePassword(String username, String newPassword);




}
