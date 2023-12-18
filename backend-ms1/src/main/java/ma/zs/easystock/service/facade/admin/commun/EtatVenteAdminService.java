package ma.zs.easystock.service.facade.admin.commun;

import java.util.List;
import ma.zs.easystock.bean.core.commun.EtatVente;
import ma.zs.easystock.dao.criteria.core.commun.EtatVenteCriteria;
import ma.zs.easystock.zynerator.service.IService;

import ma.zs.easystock.ws.dto.commun.EtatVenteDto;
import org.springframework.http.HttpEntity;


public interface EtatVenteAdminService extends  IService<EtatVente,EtatVenteCriteria>  {



    HttpEntity<byte[]> createPdf(EtatVenteDto dto) throws Exception;

}
