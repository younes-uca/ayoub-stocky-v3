package ma.zs.easystock.service.facade.admin.commun;

import java.util.List;
import ma.zs.easystock.bean.core.commun.EtatAchat;
import ma.zs.easystock.dao.criteria.core.commun.EtatAchatCriteria;
import ma.zs.easystock.zynerator.service.IService;

import ma.zs.easystock.ws.dto.commun.EtatAchatDto;
import org.springframework.http.HttpEntity;


public interface EtatAchatAdminService extends  IService<EtatAchat,EtatAchatCriteria>  {



    HttpEntity<byte[]> createPdf(EtatAchatDto dto) throws Exception;

}
