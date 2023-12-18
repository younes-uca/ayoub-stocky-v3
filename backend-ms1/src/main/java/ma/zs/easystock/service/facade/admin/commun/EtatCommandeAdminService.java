package ma.zs.easystock.service.facade.admin.commun;

import java.util.List;
import ma.zs.easystock.bean.core.commun.EtatCommande;
import ma.zs.easystock.dao.criteria.core.commun.EtatCommandeCriteria;
import ma.zs.easystock.zynerator.service.IService;

import ma.zs.easystock.ws.dto.commun.EtatCommandeDto;
import org.springframework.http.HttpEntity;


public interface EtatCommandeAdminService extends  IService<EtatCommande,EtatCommandeCriteria>  {



    HttpEntity<byte[]> createPdf(EtatCommandeDto dto) throws Exception;

}
