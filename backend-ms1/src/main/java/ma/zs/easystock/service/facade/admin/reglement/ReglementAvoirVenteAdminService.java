package ma.zs.easystock.service.facade.admin.reglement;

import java.util.List;
import ma.zs.easystock.bean.core.reglement.ReglementAvoirVente;
import ma.zs.easystock.dao.criteria.core.reglement.ReglementAvoirVenteCriteria;
import ma.zs.easystock.zynerator.service.IService;

import ma.zs.easystock.ws.dto.reglement.ReglementAvoirVenteDto;
import org.springframework.http.HttpEntity;


public interface ReglementAvoirVenteAdminService extends  IService<ReglementAvoirVente,ReglementAvoirVenteCriteria>  {

    List<ReglementAvoirVente> findByVenteId(Long id);
    int deleteByVenteId(Long id);
    long countByVenteNumeroFacture(String numeroFacture);
    List<ReglementAvoirVente> findByModeReglementId(Long id);
    int deleteByModeReglementId(Long id);
    long countByModeReglementId(Long id);
    List<ReglementAvoirVente> findByAvoirVenteId(Long id);
    int deleteByAvoirVenteId(Long id);
    long countByAvoirVenteNumeroFactureAvoirVente(String numeroFactureAvoirVente);


    HttpEntity<byte[]> createPdf(ReglementAvoirVenteDto dto) throws Exception;

}
