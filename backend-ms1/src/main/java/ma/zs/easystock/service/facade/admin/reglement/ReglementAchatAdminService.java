package ma.zs.easystock.service.facade.admin.reglement;

import java.util.List;
import ma.zs.easystock.bean.core.reglement.ReglementAchat;
import ma.zs.easystock.dao.criteria.core.reglement.ReglementAchatCriteria;
import ma.zs.easystock.zynerator.service.IService;

import ma.zs.easystock.ws.dto.reglement.ReglementAchatDto;
import org.springframework.http.HttpEntity;


public interface ReglementAchatAdminService extends  IService<ReglementAchat,ReglementAchatCriteria>  {

    List<ReglementAchat> findByAchatId(Long id);
    int deleteByAchatId(Long id);
    long countByAchatId(Long id);
    List<ReglementAchat> findByModeReglementId(Long id);
    int deleteByModeReglementId(Long id);
    long countByModeReglementId(Long id);


    HttpEntity<byte[]> createPdf(ReglementAchatDto dto) throws Exception;

}
