package ma.zs.easystock.service.facade.admin.commun;

import java.util.List;
import ma.zs.easystock.bean.core.commun.Fournisseur;
import ma.zs.easystock.dao.criteria.core.commun.FournisseurCriteria;
import ma.zs.easystock.zynerator.service.IService;

import ma.zs.easystock.ws.dto.commun.FournisseurDto;
import org.springframework.http.HttpEntity;


public interface FournisseurAdminService extends  IService<Fournisseur,FournisseurCriteria>  {
    Fournisseur findByUsername(String username);
    boolean changePassword(String username, String newPassword);



    HttpEntity<byte[]> createPdf(FournisseurDto dto) throws Exception;

}
