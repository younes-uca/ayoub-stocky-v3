package ma.zs.easystock.service.facade.admin.commun;

import java.util.List;
import ma.zs.easystock.bean.core.commun.EtatAvoirAchat;
import ma.zs.easystock.dao.criteria.core.commun.EtatAvoirAchatCriteria;
import ma.zs.easystock.zynerator.service.IService;

import ma.zs.easystock.ws.dto.commun.EtatAvoirAchatDto;
import org.springframework.http.HttpEntity;


public interface EtatAvoirAchatAdminService extends  IService<EtatAvoirAchat,EtatAvoirAchatCriteria>  {



    HttpEntity<byte[]> createPdf(EtatAvoirAchatDto dto) throws Exception;

}
