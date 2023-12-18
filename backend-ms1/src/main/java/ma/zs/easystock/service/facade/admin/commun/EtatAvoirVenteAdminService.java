package ma.zs.easystock.service.facade.admin.commun;

import java.util.List;
import ma.zs.easystock.bean.core.commun.EtatAvoirVente;
import ma.zs.easystock.dao.criteria.core.commun.EtatAvoirVenteCriteria;
import ma.zs.easystock.zynerator.service.IService;

import ma.zs.easystock.ws.dto.commun.EtatAvoirVenteDto;
import org.springframework.http.HttpEntity;


public interface EtatAvoirVenteAdminService extends  IService<EtatAvoirVente,EtatAvoirVenteCriteria>  {



    HttpEntity<byte[]> createPdf(EtatAvoirVenteDto dto) throws Exception;

}
