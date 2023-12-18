package ma.zs.easystock.service.facade.admin.reglement;

import java.util.List;
import ma.zs.easystock.bean.core.reglement.ReglementAvoirAchat;
import ma.zs.easystock.dao.criteria.core.reglement.ReglementAvoirAchatCriteria;
import ma.zs.easystock.zynerator.service.IService;

import ma.zs.easystock.ws.dto.reglement.ReglementAvoirAchatDto;
import org.springframework.http.HttpEntity;


public interface ReglementAvoirAchatAdminService extends  IService<ReglementAvoirAchat,ReglementAvoirAchatCriteria>  {

    List<ReglementAvoirAchat> findByAchatId(Long id);
    int deleteByAchatId(Long id);
    long countByAchatId(Long id);
    List<ReglementAvoirAchat> findByModeReglementId(Long id);
    int deleteByModeReglementId(Long id);
    long countByModeReglementId(Long id);
    List<ReglementAvoirAchat> findByAvoirAchatId(Long id);
    int deleteByAvoirAchatId(Long id);
    long countByAvoirAchatNumeroFactureAvoirFournisseur(String numeroFactureAvoirFournisseur);


    HttpEntity<byte[]> createPdf(ReglementAvoirAchatDto dto) throws Exception;

}
